
//w, h, cw, ch,  width height centerWidth centerHeight of canvas
//canvas, ctx, mouse, globalTime  
 image = new Image;
image.src = "images/image";
var canvas = document.getElementById("jPolygon");

const font = {
 font : "28px Arial",
 textAlign : "center",
 textBaseline : "middle",
}

function setStyle(ctx, style){
 Object.keys(style).forEach(key => ctx[key] = style[key]);
}
//Handle all key input
const keys = {  // key input object
 ArrowLeft : false,  // only add key names you want to listen to
 ArrowRight : false,
 keyEvent (event) {
     if (keys[event.code] !== undefined) {  // are we interested in this key
         keys[event.code] = event.type === "keydown";
     }
 }
}
//add key listeners
document.addEventListener("keydown", keys.keyEvent);
document.addEventListener("keyup", keys.keyEvent);


const view = (()=>{
 const matrix = [1,0,0,1,0,0]; // current view transform
 const invMatrix = [1,0,0,1,0,0]; // current inverse view transform
 var m = matrix;  // alias
 var im = invMatrix; // alias
 var rotate = 0;  // current x axis direction in radians
 var scale = 1;   // current scale
 const pos = {      // current position of origin
     x : 0,
     y : 0,
 }
 var dirty = true;
 return {
     apply(ctx){
         if(dirty){ this.update() }
         var m = matrix;
         ctx.setTransform(m[0],m[1],m[2],m[3],m[4],m[5]);
     },
     update(){ // call to update transforms
         var xdx = Math.cos(rotate) * scale;
         var xdy = Math.sin(rotate) * scale;
         m[0] = xdx;
         m[1] = xdy;
         m[2] = -xdy;
         m[3] = xdx;
         m[4] = pos.x;
         m[5] = pos.y;
         // calculate the inverse transformation
         cross = m[0] * m[3] - m[1] * m[2];
         im[0] =  m[3] / cross;
         im[1] = -m[1] / cross;
         im[2] = -m[2] / cross;
         im[3] =  m[0] / cross;
         dirty = false;
     },
     toWorld(x,y,point = {}){  // convert screen to world coords
         var xx, yy;
         if(dirty){ this.update() }
         xx = x - matrix[4];     
         yy = y - matrix[5];     
         point.x =  xx * im[0] + yy * im[2]; 
         point.y = xx * im[1] + yy * im[3];
         return point;
     },        
     toScreen(x,y,point = {}){  // convert world coords to  coords
         if(dirty){ this.update() }
         point.x =  x * m[0] + y * m[2] + m[4]; 
         point.y = x * m[1] + y * m[3] + m[5];
         return point;
     },        
     movePos(x,y){
         pos.x += x;
         pos.y += y;
         dirty = true;
     },
     setPos(x,y){
         pos.x = x;
         pos.y = y;
         dirty = true;
     },
     setScale(sc){
         scale = sc;
         dirty = true;
     },
     scaleScale(sc){
         scale *= sc;
         dirty = true;
     },
     scaleAt(x,y,sc){
         if(dirty){ this.update() }
         scale *= sc;
         pos.x = x - (x - pos.x) * sc;
         pos.y = y - (y - pos.y) * sc;            
         dirty = true;
     }
 };
})();

function onResize(){
 setStyle(ctx,font);

}
const drag = {
 dragging : false,
 lastX : 0,
 lastY : 0,
 update(){
     var dx,dy;
     if(mouse.w){
         if(mouse.w < 0){
             mouse.w += 10;
             view.scaleAt(mouse.x,mouse.y,1/1.02);
             if(mouse.w > 0){
                 mouse.w = 0;
             }
         } else if(mouse.w > 0){
             mouse.w -= 10;
             view.scaleAt(mouse.x,mouse.y,1.02);
             if(mouse.w < 0){
                 mouse.w = 0;
             }
         }
     }
     if(mouse.buttonRaw){
         if(!this.dragging){
             this.dragging = true;
             this.lastX = mouse.x;
             this.lastY = mouse.y;
         }else{
             if(mouse.buttonRaw & 1){
                 dx = mouse.x-this.lastX;
                 dy = mouse.y-this.lastY;
                 this.lastX = mouse.x;
                 this.lastY = mouse.y;
                 view.movePos(dx,dy);
             }
         }
     }else{
         if(this.dragging){
             this.dragging = false;
         }
     }
 }
}

function display() { // call once per frame
 ctx.setTransform(1, 0, 0, 1, 0, 0); // reset transform
 ctx.globalAlpha = 1; // reset alpha
 ctx.clearRect(0, 0, w, h);
 if(keys.ArrowLeft ){ mouse.w += 10 }
 if(keys.ArrowRight){ mouse.w -= 10 }
 drag.update();
 if(image.complete){
     view.apply(ctx);
     ctx.drawImage(image,0,0,640,480);
     ctx.setTransform(1, 0, 0, 1, 0, 0);
     ctx.fillText("Click drag to pan. Wheel to zoom or left/right arrow.",cw,20)
 }else{
     ctx.fillText("Loading Image...",cw,ch)
 }
}




/******************************************************************************
The code from here down is generic full page mouse and canvas boiler plate 
code. As I do many examples which all require the same mouse and canvas 
functionality I have created this code to keep a consistent interface. The
Code may or may not be part of the answer.
This code may or may not have ES6 only sections so will require a transpiler
such as babel.js to run on legacy browsers.
*****************************************************************************/
//V2.0 ES6 version for Stackoverflow and Groover QuickRun 
var w, h, cw, ch, canvas, ctx, mouse, globalTime = 0;
//You can declare onResize (Note the capital R) as a callback that is also
//called once at start up. Warning on first call canvas may not be at full
//size. 
;(function(){
 const RESIZE_DEBOUNCE_TIME = 100;
 var resizeTimeoutHandle;
 var firstRun = true;
 function createCanvas () {
     var c,cs;
     cs = (c = document.createElement("canvas")).style;
     cs.position = "absolute";
     cs.top = cs.left = "0px";
     cs.zIndex = 10;
     document.body.appendChild(c);
     return c;
 }
 function resizeCanvas () {
     if (canvas === undefined) { canvas = createCanvas() }
     canvas.width = innerWidth;
     canvas.height = innerHeight;
     ctx = canvas.getContext("2d");
     if (typeof setGlobals === "function") { setGlobals() }
     if (typeof onResize === "function") {
         clearTimeout(resizeTimeoutHandle);
         if (firstRun) { onResize() }
         else { resizeTimeoutHandle = setTimeout(onResize, RESIZE_DEBOUNCE_TIME) }
         firstRun = false;
     }
 }
 function setGlobals () {
     cw = (w = canvas.width) / 2;
     ch = (h = canvas.height) / 2;
 }
 mouse = (function () {
     function preventDefault(e) { e.preventDefault() }
     var m; // alias for mouse
     var mouse = {
         x : 0, y : 0, w : 0, // mouse position and wheel
         alt : false, shift : false, ctrl : false, // mouse modifiers 
         buttonRaw : 0,
         over : false,                        // true if mouse over the element
         buttonOnMasks : [0b1, 0b10, 0b100],  // mouse button on masks
         buttonOffMasks : [0b110, 0b101, 0b011], // mouse button off masks
         active : false,
         bounds : null,
         eventNames : "mousemove,mousedown,mouseup,mouseout,mouseover,mousewheel,DOMMouseScroll".split(","),
         event(e) {
             var t = e.type;
             m.bounds = m.element.getBoundingClientRect();
             m.x = e.pageX - m.bounds.left - scrollX;
             m.y = e.pageY - m.bounds.top - scrollY;
             m.alt = e.altKey;
             m.shift = e.shiftKey;
             m.ctrl = e.ctrlKey;
             if (t === "mousedown") { m.buttonRaw |= m.buttonOnMasks[e.which - 1] }
             else if (t === "mouseup") { m.buttonRaw &= m.buttonOffMasks[e.which - 1] }
             else if (t === "mouseout") { m.over = false }
             else if (t === "mouseover") { m.over = true }
             else if (t === "mousewheel") {
                 m.w = e.wheelDelta 
                 e.preventDefault();
             }
             else if (t === "DOMMouseScroll") { 
                 m.w = -e.detail 
                 e.preventDefault();
             }
         },
         start(element) {
             m.element = element === undefined ? document : element;
             m.eventNames.forEach(name =>  document.addEventListener(name, mouse.event) );
             document.addEventListener("contextmenu", preventDefault, false);
             m.active = true;
         },
     }
     m = mouse;
     return mouse;
 })();
 function myCanvas() {
	 
		var c = document.getElementById("jPolygon");
		var ctx = c.getContext("2d");
		ctx.canvas.width =640;
		 ctx.canvas.height = 480;
		 
		var img = document.getElementById("my_image");
		
		ctx.drawImage(img,0,0,640,480);
		
		}
 function update(timer) { // Main update loop
     globalTime = timer;
     display();           // call demo code
     requestAnimationFrame(update)
 }
 setTimeout(function(){
     //canvas = createCanvas(); 
	 
     mouse.start(canvas, true);
     resizeCanvas();
     window.addEventListener("resize", resizeCanvas);
     requestAnimationFrame(update);
 },0);
})();