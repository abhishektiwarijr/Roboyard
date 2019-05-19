package roboyard.pm.ia.ricochet;

import roboyard.pm.ia.AGameState;
import roboyard.pm.ia.AWorld;
import roboyard.pm.ia.IEndCondition;
import roboyard.pm.ia.SolverBFS;

/**
 * @author Pierre Michel
 */
public class RRSolver extends SolverBFS {

  public RRSolver(int maxDepth, AWorld world, AGameState baseState, IEndCondition endCondition){
    super(maxDepth, world, baseState, endCondition);
  }
  
  @Override
  public boolean additionnalRemovalCriteria(AGameState state) {
    RRWorld w = (RRWorld)world;
    RRGameState s = (RRGameState)state;
    for(RRPiece p : s.getMainPieces()){
      if(w.scoreAtPosition(p) + this.currentDepth <= this.maxDepth){
        return false;
      }
    }
    return true;
  }
  
}
