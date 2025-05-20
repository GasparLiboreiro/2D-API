# 2D-API
Personal API for quick 2D graphic applications

This API is only for personal use as a tool, it isn't finish'd and it isn't friendly to use
But it gets me away when I want to test something visually involving 2D space

This API contains support for:
- Rendering of any hollow 2D shape made out of lines
- Gameloop and update by delta time system

Some examples of uses for this API could be
- rendering functions
- making games
- testing shit out

# How to use this damn API (isn't that bad)

### There is a class that is called "APIMain"
APIMain has an attribute called "carga" that contains all the programs that need to be drawn and updated each frame

### For you to start using this API
You need to create your own class that extends "Program", that is gonna be your main class for this application
A "Program" has 2 main methods, 1 that returns what needs to be drawn, and 1 to update the game each frame if needed

the first has to return an ArrayList of <Drawable&gt;
A Drawable is a class that has the components needed to be drawn to the screen

The things you wanna show to the screen need to be in that array of drawables, so the things you wanna show need to be of type Drawable

The abstract class Drawable has 3 main methods
- getVertices: returns an array of 2d vectors, being the vertices of your shape
- getRelaciones: Returns an array of int matrices ( ArrayList<int[]&gt; ), this sounds complex but hear me out
                Each index of the array represents a line, this line has both points in vertecies from the array of vertices (getVertices)
                So position 0 of the array may return something like this: [2,6] which whuld be a matrix of ints
                This matrix of length 2 has the index in the array of vertices of both points of the line
                So this way you got an array of vertices and an array of relationships between this vertices
- getColor: Returns the color of the object in a ColorCl class (this class extends Color, the only feature that ColorCl adds is being able to clone the object)

Onse you have a class with all this methods, you can add them to the array of drawables in your app, and then add your app yo the APIMain load

For that you gotta go to the class called Main, create an instance of your program and put it in the params of "PanelCustom.getInstance().getApi().addProgram(/* your app here */);"
or as seen in the examples in the code





If you read this a couple of times and follow along in the code while doing so, you might be able to use this API, it isn't finished and I don't like using it, but for someone that doesn't wanna do the whole engine from scratch, this can be fine for simple test and for fun

Also, the [2D-firstperson](https://github.com/GasparLiboreiro/2D-FirstPerson) prototype was made from this API

<img src="https://github.com/GasparLiboreiro/2D-API/blob/main/imgs/funcion.png" alt="funciones" width="40%"/>
<img src="https://github.com/GasparLiboreiro/2D-API/blob/main/imgs/mandala%20(5).png" alt="mandala1" width="40%"/>
<img src="https://github.com/GasparLiboreiro/2D-API/blob/main/imgs/mandala%20(x).png" alt="mandala2" width="40%"/>
<img src="https://github.com/GasparLiboreiro/2D-API/blob/main/imgs/lineas.png" alt="lineas" width="40%"/>
