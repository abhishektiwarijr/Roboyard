package robotoyard.pm.ia.ricochet;

import robotoyard.pm.ia.AGameState;
import robotoyard.pm.ia.AWorld;
import robotoyard.pm.ia.IEndCondition;
import robotoyard.pm.ia.SolverBFS;

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
