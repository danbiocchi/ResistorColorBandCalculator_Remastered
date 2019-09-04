# ResistorColorBandCalculator_Remastered
![](https://i.imgur.com/0mExuVC.png)
![](https://i.imgur.com/sT7IIqP.png)
![](https://i.imgur.com/KaywNHC.png)

1. Button based (single use time FAST)
2. Handles 3, 4, 5 and 6 band resistors.
3. Incorrect input is IMPOSSIBLE


# Features
1. Simple color coded button selection.
2. Covers all bands (3,4,5 and 6)
3. Displays resistance calculation with proper unit.
4. Display picture of inputted resistor.
            
#### User Interface and User Experience Upcoming enhancements.
- Currently the reset button is found Under File > Reset. This requires a large mouse movement and 2 clicks. 
1. In the future a reset button will be added to the bottom of the frame, reducing mouse movement and only requiring one click.
Once this feature is complete it will be the fastest SINGLE USE and MULTI-USE resistor band calculator found on the interenet (trust me, I looked).


#### Programming Changes

Since there is 100 lines on just button creation and styling it would be better to create a ColorButton class which receives name of button and button color. Also it should automaically apply some of the other styling options. 
For now its only apparent that this should be done with JButton.



Code cleanup and restructoring with things like this - to make the main class cleaner - will take place after I finish a react application.
