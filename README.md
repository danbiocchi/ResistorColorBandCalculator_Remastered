# ResistorColorBandCalculator_Remastered
A 2019 remastered version of the project I created in highschool of 2012.
(Found here: https://github.com/danbiocchi/ResistorColorBandCalculator)

## Old Version: (2012)

![](https://i.imgur.com/bLZ71if.png)
![](https://i.imgur.com/hqOgGUl.png)
![](https://i.imgur.com/ittXWwY.png)

1. Text Based input using JOptionPanes (single use time LONG)
2. Only handles 3-4 band resistors.
3. Incorrect input was possible (and exited on incorrect input after error msg)


## New Version: (2019)

![](https://i.imgur.com/0mExuVC.png)
![](https://i.imgur.com/sT7IIqP.png)
![](https://i.imgur.com/KaywNHC.png)

1. Button based (single use time FAST)
2. Handles 3, 4, 5 and 6 band resistors.
3. Incorrect input is IMPOSSIBLE

 ### User Interface & User Experience
- UX - > The selection method for color bands are color buttons with text.
       Explanation: This makes selecting easier as most programs would use drop down menus requiring 2 clicks per band   
       selection whereas this program only requires 1. Two memory triggers - a colored background that matches the color name - provide the easiest method of identification for the user (i.e. Blue looks blue and blue is "blue"). In addition, on the darker colors where text may not be as readible, the text has been made a lighter color to ensure perfect readbility.

- UX - > All color buttons on the left side of the pane stay on the left side and right stays on right. The order in which
       they appear is also as similar as can be. As Some bands have different color ranges.
       Explanation : This makes it easy for the user to spot the colors quickly, decreasings search time and 
                     therefore increasing speed of use. If the buttons swapped chaotically as each panel switches, 
                     this would make things more difficult. Keeping them in the same place inreases memory recall through 
                     repetition - when the panel switches the user is able to find the next color since it is already in
                     a similar place as before(If a red button was above blue and on the left side, those buttons will stay in that orientaion throughout each band color selection panel. Red is never under blue or on the right side of the panel. This would create more complexity and make the user remember things like, "oh when entering the second band the red button jumps to this other location and again after that another different location", instead of "red is always on the top left" comparing these two statements it's easy to see the different in complexity).

- UX/UI - > When the user finishes band selection, the program renders a picture of what the band should look like.
            Explanation: This feature decreases user error as the user can confirm and compare what was written with the      resistor in hand. If the user finds that the colors don't match up with their resistor, he/she is going to realize an error was made, reset the program, and try again for a correct calculation. This is also a nice visual feature.
            
#### User Interface and User Experience Upcoming enhancements.
- Currently the reset button is found Under File > Reset. This requires a large mouse movement and 2 clicks. 
1. In the future a reset button will be added to the bottom of the frame, reducing mouse movement and only requiring one click.
Once this feature is complete it will be the fastest SINGLE USE and MULTI-USE resistor band calculator found on the interenet (trust me, I looked).


#### Programming Changes

Since there is 100 lines on just button creation and styling it would be better to create a ColorButton class which receives name of button and button color. Also it should automaically apply some of the other styling options. 
For now its only apparent that this should be done with JButton.



Code cleanup and restructoring with things like this - to make the main class cleaner - will take place after I finish a react application.
