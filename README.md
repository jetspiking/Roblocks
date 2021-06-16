<img src="https://raw.githubusercontent.com/jetspiking/Roblocks/main/Images/SplashscreenNew.png" width="1000">

_Accessible GUI-driven robot programming for your product_

# Description
Roblocks aims to be an accessible Graphical Programming Tool which enables basic robot programming for everyone. By configuring an outgoing JSON-protocol and recognizing this, you can link the Roblocks-GUI to your robot / product. This enables other people to control your robot, while hiding your back-end and complicated code. This makes the product an option for expositions and to let people create programs. Also fit for education purposes. 

# Overview

# Installation
Navigate to the releases tab, i.e. 
[Releases](https://github.com/jetspiking/Roblocks/releases)

From here you can download Roblocks for ```Mac OS```, ```Windows``` and ```Linux```. 
Launch the executable to startup Roblocks, it should work out of the box. 

_The application has been verified to run on Apple Silicon (```M1```)._

After the installation create your toolbox configuration ```.json``` file, as the example displayed [here](https://github.com/jetspiking/Roblocks/tree/main/Examples/JSON).


# Usage

#### Add / Remove Node(s)
Select the Visual Edit window (center) and click the "add (+)" button. To remove a Node, select it (click), and click the "remove (-)" button.

<img src="https://github.com/jetspiking/Roblocks/blob/main/Images/Application.png" width="400">

#### Add / Remove Operation(s)
Select a node (click) and click the "add (+)" button. To remove an operation, select it (click), and click the "remove (-)" button.

<img src="https://github.com/jetspiking/Roblocks/blob/main/Images/General.png" width="400">

#### Configure Operation(s)
Click on an operation inside a node and click the "settings" icon.

<img src="https://github.com/jetspiking/Roblocks/blob/main/Images/Attributes.png" width="400">

#### Compile to .json file
Click on "File", "Save Project" to save your project to the selected location on your disk.  

#### Change read / write location
Click on the app logo "RB", "Preferences" to adjust the paths for reading and writing. After closing the window the toolbox.json will be reloaded, if no previous file was loaded. 

<img src="https://github.com/jetspiking/Roblocks/blob/main/Images/Preferences.png" width="400">

#### Hiding / Showing views
Click on "View" and select the windows you would like to show / hide.

<img src="https://github.com/jetspiking/Roblocks/blob/main/Images/Views.png" width="400">

#### Log
A more detailed log can be viewed by navigating to "View" and click on "Expand log".

<img src="https://github.com/jetspiking/Roblocks/blob/main/Images/Log.png" width="400">

# Configuration (Roblocks Protocol)
[Documentation](https://htmlpreview.github.io/?https://github.com/jetspiking/Roblocks/blob/main/Documentation/Protocol/RoblocksHelp.html)

# Building
This section is inapplicable if you just want to use the application, and not tweak the Source code.  

The application has been built using IntelliJ Community Edition and uses the libraries ```gson-2.8.6``` and ```json-simple-1.1.1```. Make sure to include these as libraries using your prefered methods. 

# Roblocks-Web
Currently Roblocks-Web is being developed by Jascha Huisman ([@jaschahuisman](https://github.com/jaschahuisman)), this application enables developing a program from the web, instead of being obligated to download a desktop-client. This is also a solution for devices that are not supported by the full-application.  

The repository can be viewed [here](https://github.com/jaschahuisman/roblocks-web).

# Contributors
Huge thanks to Jascha Huisman ([@jaschahuisman] for creating awesome banners and actively sharing a lot of feedback and ideas for Roblocks, which definitely improves and has improved the application.  

# Happy Designing
View the guidelines [here](https://www.figma.com/file/TcK8W4pQsesyPY4DCCcDYV/Roblocks-design-team-library)


<img src="https://raw.githubusercontent.com/jetspiking/Roblocks/main/Images/HappyDesigning.png" width="1000">
