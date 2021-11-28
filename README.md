[![Github All Releases](https://img.shields.io/github/downloads/jetspiking/Roblocks/total.svg)]()
[![License](https://img.shields.io/github/license/jetspiking/Roblocks.svg)]()
[![Stars](https://img.shields.io/github/stars/jetspiking/Roblocks.svg)]()

<img src="https://raw.githubusercontent.com/jetspiking/Roblocks/main/Images/SplashscreenNew.png" width="1000">

_Accessible GUI-driven programming for your product_

# Description
Roblocks aims to be an accessible Graphical Programming Tool which enables programming for everyone. By configuring an outgoing JSON-protocol and recognizing this, you can link the Roblocks-GUI to your robot or product. This enables other people to control your product, while hiding your back-end and complicated code. This makes the product an option for expositions and educational purposes (to let people create programs in a more accessible way). Roblocks is especially suitable for IoT-projects and robotics, since custom JSON-messages can be used to execute your desired action(s).

# Overview

# Installation
Navigate to the releases tab, i.e. 
[Releases](https://github.com/jetspiking/Roblocks/releases)

From here you can download Roblocks for ```Mac OS```, ```Windows```, ```Linux``` and ~~```Android```~~. 
Launch the executable to startup Roblocks, it should work out of the box. 

_The application has been verified to run on Apple Silicon (```M1```)._

If you are using ```Mac OS``` you might get a message that you can not open the application, because you don't have the permissions or it would be corrupt. You can fix this by opening terminal and executing the following command: 

```xattr -d com.apple.quarantine /path/to/roblocks.app```


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

# Help
Need help and don't know where to start? Feel free to open an issue. Describe your project, use-case(s) and issues so we can attempt to support and help you out as good as possible.  

# Building
This section is inapplicable if you just want to use the application, and not tweak the Source code.  

The application has been built using IntelliJ Community Edition and uses the libraries ```gson-2.8.6``` and ```json-simple-1.1.1```. Make sure to include these as libraries using your prefered methods. 

# Contributors
Huge thanks to Jascha Huisman ([@jaschahuisman](https://github.com/jaschahuisman)) for creating awesome banners and actively sharing a lot of feedback and ideas for Roblocks, which definitely improves and has improved the application.  

# Happy Designing
View the guidelines [here](https://www.figma.com/file/TcK8W4pQsesyPY4DCCcDYV/Roblocks-design-team-library)

# Thank you for using Roblocks
If you enjoy Roblocks and feel like it's an improvement and you want to support me, you could consider buying me a drink by navigating to my Buy Me A Coffee account.

<a href="https://www.buymeacoffee.com/DustinHendriks" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/default-orange.png" alt="Buy Me A Coffee" height="41" width="174"></a>

<img src="https://raw.githubusercontent.com/jetspiking/Roblocks/main/Images/HappyDesigning.png" width="1000">
