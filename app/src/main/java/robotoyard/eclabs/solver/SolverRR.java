package robotoyard.eclabs.solver;


import java.util.ArrayList;

import robotoyard.eclabs.GridElement;
import robotoyard.pm.ia.AGameState;
import robotoyard.pm.ia.GameSolution;
import robotoyard.pm.ia.IGameMove;
import robotoyard.pm.ia.ricochet.RREndCondition;
import robotoyard.pm.ia.ricochet.RRGameMove;
import robotoyard.pm.ia.ricochet.RRGameState;
import robotoyard.pm.ia.ricochet.RRGetMap;
import robotoyard.pm.ia.ricochet.RRPiece;
import robotoyard.pm.ia.ricochet.RRSolver;
import robotoyard.pm.ia.ricochet.RRWorld;

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
