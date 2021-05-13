<img src="https://raw.githubusercontent.com/jetspiking/Roblocks/main/Images/Splashscreen.png" width="450">

_Accessible GUI-driven robot programming for your product_

# Description
Roblocks is an accessible Graphical Programming Tool which enables basic robot programming for everyone. By configuring an outgoing JSON-protocol and recognizing this, you can link the Roblocks-GUI to your robot / product. This enables other people to control your robot, while hiding your back-end and complicated code. This makes the product an option for expositions and to let people create programs. Also fit for education purposes. 

# Overview

# Installation
Navigate to the releases tab, i.e. 
[Releases](https://github.com/jetspiking/Roblocks/releases)

From here you can download Roblocks for ```Mac OS```, ```Windows``` and ```Linux```. 
Launch the executable to startup Roblocks, it should work out of the box. 

_The application has been verified to run on Apple Silicon (```M1```)._

# Usage

#### Add / Remove Node(s)
Select the Visual Edit window (center) and click the "add (+)" icon.

<img src="https://github.com/jetspiking/Roblocks/blob/main/Images/Application.png" width="400">

#### Add / Remove Operation(s)
Select a node (click) and click the "add (+)" icon.

<img src="https://github.com/jetspiking/Roblocks/blob/main/Images/General.png" width="400">

#### Configure Operation(s)
Click on an operation inside a node and click the "settings" icon.

<img src="https://github.com/jetspiking/Roblocks/blob/main/Images/Attributes.png" width="400">

#### Compile to .json file
Click on "File" --> "Save Project" to save your project to the selected location on your disk.  

#### Change read / write location
Click on "App (RB)" --> "Preferences" to adjust the paths for reading and writing. 

<img src="https://github.com/jetspiking/Roblocks/blob/main/Images/Preferences.png" width="400">

#### Hiding / Showing views
Click on "View" and select the windows you would like to see.

<img src="https://github.com/jetspiking/Roblocks/blob/main/Images/Views.png" width="400">

#### Log
A more detailed log can be viewed by navigating to "View" and click on "Expand log".

<img src="https://github.com/jetspiking/Roblocks/blob/main/Images/Log.png" width="400">

# Configuration (Roblocks Protocol)
[Documentation](https://htmlpreview.github.io/?https://github.com/jetspiking/Roblocks/blob/main/Roblocks/resources/files/RoblocksHelpDoc.html)

# Building
This section is inapplicable if you just want to use the application, and not tweak the Source code.  

The application has been built using IntelliJ Community Edition and uses the libraries ```Gson-2.8.6``` and ```json-simple-1.1.1```. Make sure to include these as libraries using your prefered methods. 
