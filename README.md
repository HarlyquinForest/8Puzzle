<h1>8 Puzzle Implementation</h1>
<p>8 Puzzle solver in java</p>

<h3>Getting Started</h3>
<p>
If you intrested for this project or you need this for your homework you can use it . 
Just download the zip or clone it on you machine and here you go ;)
<h4>Requirments</h4>
First thing first , You need to install java in your Machine no matter wich OS .  

You can find installation guide <a href="https://lmgtfy.com/?q=how+to+install+java+" >here</a>
</p>
<p>
And you have to know some basic thing about java and OPP (Object Oriented Programming) . In case you don't <a href="https://lmgtfy.com/?q=java+tutorial">here</a> is the link for toturials ;)

</p>


<h4>Installing</h4>
<p>
Just clone it , or download the jar from release page 
</p>

<h4>Usage(How to use it)</h4>
<p>
There are three algorithm you can solve your puzzle with them 
</p>

<h5>Step-1</h5>
<p>import package where your main method is</p>
<code >import ir.harlyquinforest.puzzle;</code>

<h5>Step-2</h5>
<p>two arrays , one for inital state and other for goal state</p>
<pre>int[] start = {1,2,3,7,4,8,0,6,5};
int[] goal  = {1,2,3,4,5,6,7,8,0};
</pre>

<h5>Step-3</h5>
<p>Make an object from Heuristic class , pass goal array and heuristic mode as arguments for costructor</p>
<p>There is three state for mode :</p>
<ul>
	<li> 0 = Bad Placed Heuristic </li>
	<li> 1 = Manattan Heuristic  </li>
	<li>-1 = no Heuristic (Default mode) </li>
</ul>
<pre>
<code>
Heuristic heuristic = new Heuristic(goal ,0);
</code>
</pre>

<h5>Step-4</h5>
<p>Make an Object form PuzzleNode class . That would be your starting node </p>
<pre><code>
PuzzleNode root = new PuzzleNode(s, heuristic);
root.printState(); // print puzzle state , Depth , F , Heuristic and path
</code></pre>

<h5>Step-5</h5>
<p>Now here you have three options as I mentioned ealier</p>
<ul>
	<li>BFS(Breadth First Search)</li>
	<li>A-start(Heuristic Search)</li>
	<li>RBFS(Recursive Best First Search)</li>
</ul>
<h5>BFS</h5>
<pre><code>
BFS bfs = new BFS(root);
bfs.solve().printState();
</code></pre>
<p><code>solve()</code> Method has PuzzleNode return type , so we can use returned object to print path and other stuff . This method is same in all three algorithms</p>
<h5>A-star</h5>
<p>For A-star and RBFS you need to create another Heuristic object that mode value must be 0 or 1 , If mode set to -1 this algorithm will work as BFS </P>
<pre><code>
heuristic = new Heuristic(goal ,1); // assign new object for heuristic 
root = new PuzzleNode(s, heuristic);
Astar astar = new Astar(start);
astar.solve().printState();
</code></pre>

<h5>RBFS</h5>
<p>For this algorithm heuristic must be 0 or 1 unless it won't work !!!!!</p>
<pre><code>
heuristic = new Heuristic(goal ,1); // assign new object for heuristic 
root = new PuzzleNode(s, heuristic);
RBFS rbfs = new Astar(start);
rbfs.solve().printState();
</code></pre>

<h3>Built With</h3>
<ul>
	<li>Java</li>
	<li>A lot of Coffee</li>
	<li>Keyboard</li>
	<li>Intellij Idea</li>
	<li>and of Course StackOverFlow </li>
</ul>

