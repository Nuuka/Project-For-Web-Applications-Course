<script>
	//var c = document.getElementById("myCanvas");
	//var ctx = c.getContext("2d");
	//ctx.scale(0.4, 0.4);
	var x = 400;
	var y = 200;
	var w = (x/2);
	var test;
	var nodesx = []; // node x coords
	var nodesy = []; // node y coords
	var nodesw = []; // node width
	var nodeLeft = []; // node left id
	var nodeRight = []; // node right id
	var ydrop = 50; // amount of pixels to draw next row on
	var circleWidth = 10;
	var levels = 0;
	//ctx.font = "15px Arial";


	storeNode(1,2,0);
	storeNode(2,0,9);
	storeNode(9,10,11);
	storeNode(10,12,0);


	
	
	

	
	var svg = document.createElementNS("http://www.w3.org/2000/svg", "svg");
	svg.setAttributeNS (null, "width", 0);
	//svg.setAttributeNS (null, "height", 500);
	svg.setAttributeNS (null, "id", "viewNodeBox");
	svg.setAttributeNS (null, "style", "display: inline; width: 99.5%; min-width: inherit; max-width: inherit; height: 50%;border-style:solid;border-width:1px;border-color:black;");
	svg.setAttributeNS (null, "viewBox", "0 0 900 900");
	var svgNS = svg.namespaceURI;
	loopThrough();
	
	document.getElementById("center").appendChild(svg);

	
	function drawline(x,y,xd,yd){
		var circle = document.createElementNS(svgNS,'line');
		circle.setAttribute('x1',x);
		circle.setAttribute('y1',y);
		circle.setAttribute('x2',xd);
		circle.setAttribute('y2',yd);
		circle.setAttribute('style','stroke:rgb(255,0,0);stroke-width:2');
		
		svg.appendChild(circle);
	
	}
	function drawblackline(x,y,xd,yd){
		var circle = document.createElementNS(svgNS,'line');
		circle.setAttribute('x1',x);
		circle.setAttribute('y1',y);
		circle.setAttribute('x2',xd);
		circle.setAttribute('y2',yd);
		circle.setAttribute('style','stroke:rgb(0,0,0);stroke-width:2');
		svg.appendChild(circle);
	
	}
	function drawcircle(x,y,nodeid){
		var circle = document.createElementNS(svgNS,'circle');
		circle.setAttribute('cx',x);
		circle.setAttribute('cy',y);
		circle.setAttribute('r',10);
		circle.setAttribute('stroke','green');
		circle.setAttribute('stroke-width',2);
		circle.setAttribute('fill','yellow');
		circle.setAttribute('onmouseover',"evt.target.setAttribute('fill', 'black');");
		circle.setAttribute('onmouseout',"evt.target.setAttribute('fill', 'yellow');");
		circle.setAttribute('xlink:href','www.google.com');

		svg.appendChild(circle);
		var text = document.createElementNS(svgNS,'text');
		text.setAttribute('x',x);
		text.setAttribute('y',y-12);
		text.setAttribute('fill','black');
		var t=document.createTextNode(nodeid);
		text.appendChild(t);
		svg.appendChild(text);
		//<text x="0" y="15" fill="red">I love SVG!</text>
	}
	/*
		Function to loop drawing the branches.
		It will not draw a branch if there is no left node id.
		It will stop attempting to draw branches after getting (maxTries) failed branches in a row.
	*/
	function loopThrough(){
		drawnodebranch(1);
		var numOfUndefined = 0; //number of undefined in a row
		var maxTries = 50;
		for (i = 2;; i++){
			if(nodeLeft[i] == undefined){
				numOfUndefined += 1;
			}else{
				drawnodebranch(i);
				numOfUndefined = 0;
			}
			
			if(numOfUndefined >= maxTries){
				break;
			}
		}
		
		
	}
	function drawbranch(x,y,w,nodeid){

		if(nodeLeft[nodeid] != 0){
			//draw left branch
			drawline(x,y,x-w,y+ydrop);
			drawcircle(x-w,y+ydrop,nodeLeft[nodeid]);
			//save node
			nodesx[nodeLeft[nodeid]] = x-w;
			nodesy[nodeLeft[nodeid]] = y+ydrop;
			nodesw[nodeLeft[nodeid]] = w;
		}
		if(nodeRight[nodeid] != 0){
			//draw right branch
			drawline(x,y,x+w,y+ydrop);
			drawcircle(x+w,y+ydrop,nodeRight[nodeid]);
			//save node
			nodesx[nodeRight[nodeid]] = x+w;
			nodesy[nodeRight[nodeid]] = y+ydrop;
			nodesw[nodeRight[nodeid]] = w;
			//nodeCount += 1;
		}
	}

	/*
		Used to draw the entire node.
	*/
	function drawnodebranch(nodeid){
		if(nodeid == 1){
			//draw the first node
			drawcircle(x,y,nodeid);
		}else if (nodeid != 0){
			y = nodesy[nodeid];
			x = nodesx[nodeid];
			w = nodesw[nodeid];
		}
		//drawbranch(x,y,w/2);
		if(nodeid != 0){
			drawbranch(x,y,w/2,nodeid);
		}

	}
	function storeNode(nodeid,leftid,rightid){
		nodeLeft[nodeid] = leftid;
		nodeRight[nodeid] = rightid;
	}
	function out(string){
		document.write(string);
	}
	

	  // Don't use window.onLoad like this in production, because it can only listen to one function.
	  window.onload = function() {
		// Expose to window namespase for testing purposes
		window.zoomTiger = svgPanZoom('#viewNodeBox', {
		  zoomEnabled: true,
		  controlIconsEnabled: true,
		  fit: true,
		  center: true,
		  // viewportSelector: document.getElementById('demo-tiger').querySelector('#g4') // this option will make library to misbehave. Viewport should have no transform attribute
		});
	  };
</script>