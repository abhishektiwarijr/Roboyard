package roboyard.pm.ia;

/**
 *
 * @author Pierre Michel
 */
public interface IEndCondition {
  boolean checkEnd(AWorld world, AGameState state);
}
