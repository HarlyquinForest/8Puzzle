# 8 Puzzle Implementation
Application to solve 8 puzzle with AI algorithms : BFS,A*,RBFS

## Getting Started
If you intrested for this project or you need this for your homework you can use it . 
Just download the zip or clone it on you machine and here you go ;)

### Requirments
First thing first , You need to install java in your Machine no matter wich OS .

You can find installation guide [here](https://lmgtfy.com/?q=how+to+install+java+)

And you have to know some basic thing about java and OPP (Object-oriented programming) . In case you don't [here](https://lmgtfy.com/?q=java+tutorial) is the link for toturials ;)


## How to Use

You have two options here , Download library or executable application 

### Execute
Execute 8PuzzleSolver.jar 
```
java -jar 8PuzzleSolver.jar
```

### How to use library
There are three algorithm you can solve your puzzle with them 

### Step-1
import package where your main method is
```
import ir.harlyquinforest.puzzle;
```
### Step-2
two arrays , one for inital state and other for goal state
```
int[] start = {1,2,3,7,4,8,0,6,5};
int[] goal  = {1,2,3,4,5,6,7,8,0};
```

### Step-3
Make an object from Heuristic class , pass goal array and heuristic mode as arguments for costructor
There is three state for mode :

	*  0 = Bad Placed Heuristic
	*  1 = Manattan Heuristic
	* -1 = no Heuristic (Default mode)

```
Heuristic heuristic = new Heuristic(goal ,0);
```

### Step-4
Make an Object form PuzzleNode class . That would be your starting node
```
PuzzleNode root = new PuzzleNode(s, heuristic);
root.printState(); // print puzzle state , Depth , F , Heuristic and path
```

### Step-5
Now here you have three options as I mentioned ealier

	* BFS(Breadth First Search
	* A-start(Heuristic Search)
	* RBFS(Recursive Best First Search)

### BFS
```
BFS bfs = new BFS(root);
bfs.solve().printState();
```
solve() Method has PuzzleNode return type , so we can use returned object to print path and other stuff . This method is same in all three algorithms

### A-star
For A-star and RBFS you need to create another Heuristic object that mode value must be 0 or 1 , If mode set to -1 this algorithm will work as BFS
```
heuristic = new Heuristic(goal ,1); // assign new object for heuristic 
root = new PuzzleNode(s, heuristic);
Astar astar = new Astar(start);
astar.solve().printState();
```

### RBFS
For this algorithm heuristic must be 0 or 1 unless it won't work !!!!!
```
heuristic = new Heuristic(goal ,1); // assign new object for heuristic 
root = new PuzzleNode(s, heuristic);
RBFS rbfs = new Astar(start);
rbfs.solve().printState();
```

## Built With

*Java
*A lot of Coffee
*Keyboard
*Intellij Idea
*and of Course StackOverFlow

Thanks for visiting us :)

