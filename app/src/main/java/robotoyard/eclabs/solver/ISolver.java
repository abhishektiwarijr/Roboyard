package robotoyard.eclabs.solver;

import java.util.ArrayList;
import java.util.List;

import driftingdroids.model.*;
import robotoyard.eclabs.GridElement;
import robotoyard.pm.ia.GameSolution;
import robotoyard.pm.ia.ricochet.RRGetMap;

/**
 * Created by Pierre on 15/04/2015.
 */
public interface ISolver extends Runnable {

    public void init(ArrayList<GridElement> elements);
    public void run();
    public SolverStatus getSolverStatus();
    public GameSolution getSolution();
}
