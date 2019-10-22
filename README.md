# Dungeons and Dragons (5E) Character Sheet. 
Contents and description (by directory)

lib folder holds any libraries that might be used. Currently, there are no libraries in use for the project and these contents will likely be removed

nbproject folder holds files necessary for NetBeans IDE. Not relevant to project

src holds all data relevant to project

Inside the src folder

<b>app</b> directory holds the Main.class and AppManager.class, these classes serve as the Application running without any GUI to it.
<ul>
  <li> Main.class is responsible for launching the application </li>
  <li> AppManager.class is responsible for controlling the GUI and validating data that is manipulated within the GUI </li>
</ul>
    
<b>constants</b> directory holds (some deprecated) constants used for coder legibility. Holds the vital KEY class that ties data to identifier
<ul>
  <li> KEY.class is class that associates each Swing component with a particular key. This is currently used for data validation and will be used for file i/o</li>
  <li> GUI.class is an old class that is deprecated, it's intent was to provide consistent labelling and enable localization (Spanish, etc.)</li>
  <li> TEXT.class is an old class that is deprecated, it's intent was to provide a uniform standard for JTextField columns </li>
  <li> Card.class is a class that is used for controlling card mechanisms (CardLayout). It requires refactoring and will be deprecated soon </li>
</ul>

<b>container</b> directory holds Graphical User Interface classes, including the CharacterFrame (main frame responsible for GUI)
<ul>
  <li>Each panel in this folder is part of the CardLayout format, allowing the user to "flip pages"</li>
  <li>CharacterFrame.class is the meat of the GUI, this class is responsible for initailization of the GUI updating of values</li>
  <li>The listeners are responsible for communicating with the AppManager when data is changed</li>
</ul>
<b>util</b> directory holds classes that are used to assist other classes in performing methods (e.g. isANumber or File IO [upcoming])

