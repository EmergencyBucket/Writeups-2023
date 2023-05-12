# Taniks - Hard
**Author:** [hello7#0007](https://github.com/hello7)

### Files
[Taniks](https://storage.ebucket.dev/taniks.pdf)

## Description
I love destiny 2. Get all the answers and combine them. For words take the first letter. All capitalized. If you have multiple numbers i.e. 1,2 it will become 12. Wrap in ``bucket{}``

## Solve
Taniks Writeup:

I will use ‘M’ to refer to the Mobile Carrier, ‘T’ for the Technical, ‘L’ for the Left Core, ‘R’ for the Right Core, and numbers for the Zone the Cores must go. For example, MR5 means the Mobile Carrier picked up the Right Core to go to Zone 5.

The distance for the Mobile Carrier is between an indicated Zone and a Core. The distance for the Technical Carrier is the sum of the distance between the three nodes nearest to the Device, the distance between the Core and either the left or right Node, and the distance between the Zone and the opposing Node. 

Below are the diagrams for the necessary info for each Round. Note that I did measurements physically, but the ratios of each calculation should be the same and has been verified with several other tools, physical and virtual.

Phase 1:
Round 1:
The Device goes to Zones 1 and 2 and indicates Zones 5 and 6. 
Should the Technical Carrier take the Left or Right Core? 
RIGHT. The Carriers want to minimize their total time, which comes down to the Technical Carrier. By measuring the distance from each node to Zones 5 and 6, the shortest distance for the Technical Carrier is TR6, therefore meaning the answer is RIGHT.
Should the Mobile Carrier go to Zone 5 or 6? 
5. In the question above, we established that the Technical Carrier is going to Zone 6, so the Mobile Carrier must go to Zone 5.
Round 2: 
The Device goes to a new location and indicates Zones 3 and 4
What is the color of the Zones that the Device is near? 
ORANGE. In Round 1, the Device went to the Gray location. In Round 2, the Device indicated Zones 3 and 4. Because the Device can not be in the same location as the indicated Zones AND cannot go to the same place twice in one phase, the Device must be near Zones 5 and 6, which are ORANGE.
Should the Mobile Carrier take the Left or Right Core? 
LEFT. The Technical Carrier should end at the Node nearest to Zones 3 and 4. To do that, they must take the Right Core, so the Mobile Carrier should take the LEFT core.
Should the Mobile Carrier go to Zone 3 or 4? 
3. From the question above, we know the Mobile Carrier will take the Left Core. If we mapped out TR3 vs TR4, TR4 is shorter, so the Mobile Carrier should go to Zone 3.
Phase 2:
Round 3:
The Device indicates Zone 2 and 4
Which Zone should the Mobile Carrier go to? 
2. First off, the Device must be in the Orange location because of the indicated Zones. The shortest distance between TL2, TR2, TL4, and TR4 is TR4, so the Mobile Carrier should go to Zone 2.
Should the Technical Carrier take the Left or Right Core? 
RIGHT. From the previous answer’s measurements, the Technical Carrier should take the Right Core.
Round 4: *Postscript note at the bottom regarding Round 4
The Device indicates Zone 3
Which Zone(s) must the Device also indicate in order for the Mobile Carrier to take the Right Core? 
4. If the Device indicates Zone 3 and was at the Orange location, the Device must now be at the Gray location. First, measure TR3, TL3 and compare it to TR4 and TL4, TR5 and TL5, and TR6 and TL6. For Zones 3 and 4, the most time-efficient route would be MR4 TL3. For 3 and 5, the most optimal is ML3 TR5. For 3 and 6, the most optimal is ML3 TR6. Only Zones 3 and 4 have the Mobile Carrier taking the Right Core, so the answer is 4.
The Mobile Carrier goes to Zone 3. Which other Zone(s) could have been indicated? 
5, 6. We have found the most optimal paths in the question above. From it, we can determine that the Mobile Carrier goes to Zone 3 if the Device indicated Zone 5 and 6 along with Zone 3.
Phase 3:
Round 5:
The Device goes to a location that it has not gone to in Phases 1 and 2.
The Device indicates the closest Zone to the Right Core. What Zone would that be? 
2. First off, the Device must be in the Blue location. The closest Zone to the Right Core is Zone 2, determined by measuring the distance between the Right Core and the other possible Zones (Not Zone 3 or 4 because the Device cannot indicate them as they are in the same location as the Device).
The Device indicates the Zone from the previous question and a Zone from another pair that allows the Technical Carrier to travel the least distance. Which Zone from that pair was indicated? 
5. The remaining possible Zones are 5 and 6 because of the Device’s location and the fact that the problem states that the Zone is not in the same pair as Zone 2 (from the question). By finding the distances of TR5, TL5, TR6, and TL6, we can determine that the shortest distance is TL5, so the answer is Zone 5.
Round 6:
The Device goes to the location of Round 4 and indicates Zone 6 and one of the Zone answers from Round 5.
Should the Techincal Carrier take the Left or Right Core? 
RIGHT. From the first question of Round 4, we know the Device is now in the Gray location. Because the device is in the Gray location, we know the indicated Zone cannot be Zone 2, therefore meaning the indicates Zones are 5 and 6. From the first question of Round 1, the answer is RIGHT.
What is the sum of the Zone numbers that the Device indicates? 
11. 5 + 6 = 11
Final Questions:
In total, how many times has the Device gone to the Gray location? 
3. The Device has gone to the Gray location in the first round because the indicated Zones were 1 and 2, so the Device cannot have gone to Gray in Round 2. In Phase 2, we determined the Device went to the Gray area in Round 4. Finally, in Phase 3, the Device went to the same location as Round 4 from the question. Therefore, the answer is 3.
How many times did the Technical Carrier take the LEFT Core? 
1. In Rounds 1 and 2, we already know the Technical Carrier took the Right Cores. In the second question to Round 3, we know the Technical Carrier did NOT take the Left Core. 
The second question of Round 4 establishes that the Mobile Carrier went to Zone 3, so the other indicated Zone is Zone 5 or 6. The first question of Round 4 establishes that the Mobile Carrier takes the Left Core when the Zones are 3 and 5 or 6, so the Technical Carrier must have taken the Right Core in Round 4. 
Round 5’s questions establish that the indicated Zones are 2 and 5 and that the Device is in the Blue location. The second question of Round 5, which determines that the Technical Carrier traveled the least distance, means the Technical Carrier went to Zone 5 after taking the LEFT core. Round 6 is the same as Round 1, so the final answer is 1.
In total, how many times did the Mobile Carrier deposit at Zone 5? 
2. The Rounds in which the Device indicated Zone 5 are Rounds 1, 4, and 6. In Rounds 1 and 6, the Mobile Carrier went to Zone 5. In Round 4, the questions specifically state that the Mobile Carrier went to Zone 3 instead, therefore the final answer is 2.
Which Round did the Device go to that it also went in Round 2? 
3. Round 2’s first question establishes that the Device went to the Orange location. Based on the indicated Zones, the only other time the Device went to Orange was in Round 3.
In which Phase did the Device end on the location that it went to the most? 
2, 3. The Device went to the Gray location the most. It went to the Gray location on Rounds 1, 4, and 6. The Phases end on even number Rounds, so the answer is Phases 2 and 3.

TL;DR: The answers:
Round 1: 
Right
5
Round 2:
Orange
Left
3
Round 3:
2
Right
Round 4:
4
5, 6
Round 5:
2
5
Round 6:
Right
11
Final Questions
3
1
2
3
2, 3

Combining all these answers should generate the following flag:

``bucket{R5OL32R45625R11312323}``

*POSTSCRIPT:
The measurements for Round 4 Question 1 were very very close its answer could have been altered through human error or something similar. An alternative answer for Zones 3 and 5 would have been MR5 TL3, which would have changed its answer to 4, 5. This would cause the following answer to be just 6. This change alone would not change the flag, but because of this change, the answer to the second final question would have been 1 OR 2. 

If you made this calculation instead, your flag would have looked like one of the following, depending on your answer to the second final question (the bolded number is the change):

``bucket{R5OL32R45625R11312323}``
``bucket{R5OL32R45625R11322323}``
