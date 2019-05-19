package roboyard.eclabs.solver;


import java.util.ArrayList;

import roboyard.eclabs.GridElement;
import roboyard.pm.ia.AGameState;
import roboyard.pm.ia.GameSolution;
import roboyard.pm.ia.IGameMove;
import roboyard.pm.ia.ricochet.RREndCondition;
import roboyard.pm.ia.ricochet.RRGameMove;
import roboyard.pm.ia.ricochet.RRGameState;
import roboyard.pm.ia.ricochet.RRGetMap;
import roboyard.pm.ia.ricochet.RRPiece;
import roboyard.pm.ia.ricochet.RRSolver;
import roboyard.pm.ia.ricochet.RRWorld;

/**
 * Created by Pierre on 08/03/2015.
 */
public class SolverRR implements ISolver{

    private SolverStatus solverStatus;
    private RRSolver solver;
    private GameSolution solution;

    public SolverRR(){
        solver = null;
        solverStatus = SolverStatus.idle;
        solution = null;
    }

    public void init(ArrayList<GridElement> elements){

        RRWorld world = null;
        String text = null;

        RRGameState baseState = new RRGameState(null, null);

        world = RRGetMap.createWorld(elements, baseState);

        RREndCondition endCondition = new RREndCondition();

        world.precomputeGrid();

        solver = new RRSolver(10, world, baseState, endCondition);
    }

    public void run() {

        if(solver == null){
            return;
        }

        solverStatus = SolverStatus.solving;

        System.out.println("------ IA START ------");
        solution = solver.solve();

        if(solution == null){
            System.out.println("------ IA NO SOLUTION ------");
            solverStatus = SolverStatus.noSolution;
        }else{
            System.out.println("------ IA SOLUTION ------");
            solverStatus = SolverStatus.solved;
            for(IGameMove m : solution.getMoves()){
                RRGameMove move = (RRGameMove)m;
                System.out.println(move.getColor() + " -> " + move.getMove());
            }
        }
        System.out.println("------ IA DONE ------");
    }

    public SolverStatus getSolverStatus(){
        return this.solverStatus;
    }

    public GameSolution getSolution(){
        return this.solution;
    }

}
