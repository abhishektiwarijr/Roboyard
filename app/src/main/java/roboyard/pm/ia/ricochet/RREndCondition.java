package roboyard.pm.ia.ricochet;

import roboyard.pm.ia.AGameState;
import roboyard.pm.ia.AWorld;
import roboyard.pm.ia.IEndCondition;

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
