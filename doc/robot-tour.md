## Manual

### Robot Tour

First we want to plot the points of the problem on a graph. The `manual/plot` namespace does this using Quil, like the examples below:

<img src="https://raw.github.com/marsmining/manual/master/doc/img/robot-tour-00.png"
     width="75%" height="75%">

Then we can plot some sample problem data:

        (def s0 [[ 0  9] [ 2  8] [ 5  6] [ 5  2]
                 [ 4  0] [ 3 -2] [ 0 -5] [-3 -4]
                 [-5 -1] [-7  2] [-5  5] [-4  7]])

<img src="https://raw.github.com/marsmining/manual/master/doc/img/robot-tour-01.png"
     width="75%" height="75%">

After using the simple "nearest neighbor" heuristic:

<img src="https://raw.github.com/marsmining/manual/master/doc/img/robot-tour-02.png"
     width="75%" height="75%">