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

[Unfinished feature: band drawing - see enhcancements sections]

1. Button based (single use time FAST)
2. Handles 3, 4, 5 and 6 band resistors.
3. Incorerct input is IMPOSSIBLE


- UX - > The selection method for color bands are color buttons with text.
       explanation: This makes selecting easier as most programs would use drop down menus requiring 2 clicks per band   
       selection whereas this program only requires 1. Combined with the color background is a text with the color name. Providing the easiest method of identification for the user providing two memory triggers. (ex. Blue looks blue and blue is "blue"). 
- UX - > All color buttons on the left side of the pane stay on the left side and right stays on right.
       explanation : This makes it easier for the user to spot the colors faster decreasings search time
                     therefore increasing use speed. If the buttons swapped chaotically on each panel switch
                     this would make things more difficult. Keeping them the same inreases memory recal through 
                     repition thus when the panel switchs the user has an easier time finding the next color
                     as it is already in a similar place it was found before.
- UX/UI - > When the user finished band selection the program renders a picture of what the band should look like.
            explanation: This feature decreases user error as the user can confirm and compare what was written with the      object that is most likely in hand. If the user finds that the colors don't match up he/she is going to realize an error was made and not take the calculation as correct. This is also a nice visual feature.
