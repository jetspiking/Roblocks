![Splashscreen](https://raw.githubusercontent.com/jetspiking/Roblocks/main/Images/Splashscreen.png)

_Accessible GUI-driven robot programming for your product_

# Description
Roblocks is an accessible Graphical Programming Tool which enables basic robot programming for everyone. By configuring an outgoing JSON-protocol and recognizing this, you can link the Roblocks-GUI to your robot / product. This enables other people to control your robot, while hiding your back-end and complicated code. This makes the product an option for expositions and to let people create programs. Also fit for education purposes. 

# Overview

# Installation
Navigate to the releases tab, i.e. 
```https://github.com/jetspiking/Roblocks/releases```. 

From here you can download Roblocks for ```Mac OS```, ```Windows``` and ```Linux```. 
Launch the executable to startup Roblocks, it should work out of the box. 

_The application has been verified to run on Apple Silicon (```M1```)._

# Usage

#### Add / Remove Node(s)
Select the Visual Edit window (center) and click the "add (+)" icon.

<img src="https://github.com/jetspiking/Roblocks/blob/main/Images/Application.png" width="700">

#### Add / Remove Operation(s)
Select a node (click) and click the "add (+)" icon.
![](https://github.com/jetspiking/Roblocks/blob/main/Images/General.png)

#### Configure Operation(s)
Click on an operation inside a node and click the "settings" icon.
![](https://github.com/jetspiking/Roblocks/blob/main/Images/Attributes.png)

#### Compile to .json file
Click on "File" --> "Save Project" to save your project to the selected location on your disk.  

#### Change read / write location
Click on "App (RB)" --> "Preferences" to adjust the paths for reading and writing. 
![](https://github.com/jetspiking/Roblocks/blob/main/Images/Preferences.png)

#### Hiding / Showing views
Click on "View" and select the windows you would like to see.
![](https://github.com/jetspiking/Roblocks/blob/main/Images/Views.png)

#### Log
A more detailed log can be viewed by navigating to "View" and click on "Expand log".
![](https://github.com/jetspiking/Roblocks/blob/main/Images/Log.png)

# Configuration (Roblocks Protocol)

# Building
This section is inapplicable if you just want to use the application, and not tweak the Source code.  

The application has been built using IntelliJ Community Edition and uses the libraries ```Gson-2.8.6``` and ```json-simple-1.1.1```. Make sure to include these as libraries using your prefered methods. 
