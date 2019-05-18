package robotoyard.pm.ia.ricochet;

import robotoyard.pm.ia.AGameState;
import robotoyard.pm.ia.AWorld;
import robotoyard.pm.ia.IEndCondition;

/**
 *
 * @author Pierre Michel
 */
public class RREndCondition implements IEndCondition{

  @Override
  public boolean checkEnd(AWorld world, AGameState state) {
    for(RRPiece p :((RRGameState)state).getMainPieces()){
      if(((RRWorld)world).isOnObjective(p)){
        return true;
      }
    }
    return false;
  }
  
}
