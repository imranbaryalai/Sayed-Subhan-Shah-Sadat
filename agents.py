"""
Baheshta Abed Rahimi

Random Agent:
Mean: 1366.5
Standard Deviation: 338.8
Individual Results: 1158, 1768, 1450, 1248, 1861, 928, 1714, 1094, 1481, 963

Reflex Agent:
Mean: 476.4
Standard Deviation: 191.9
Individual Results: 589, 294, 642, 216, 761, 498, 749, 376, 241, 398

The Reflex Agent is more efficient than the Random Agent because it will take up at least food only if there is any food
adjacent to it. The Random Agent depends on chance which is why it can't really be any more or less effective.
"""

import random
from game import Agent
from game import Directions

class BasicAgent(Agent):
  """This Agent just heads North until it cannot move"""
  def getAction(self, state):
    legalActions = state.getLegalPacmanActions()
    if Directions.NORTH in legalActions:
      return Directions.NORTH
    #Code Modidication
    else:
      return Directions.STOP

class RandomAgent(Agent):
  """This Agent chooses Random Legal Moves"""
  def getAction(self, state):
    legalActions = state.getLegalPacmanActions()
    #In here it checks if stop only action and removes it.
    legalActions.remove(Directions.STOP)
    if len(legalActions) == 0:
      return Directions.STOP
    else:
      return legalActions[random.randint(0, len(legalActions) - 1)]

class ReflexAgent(Agent):
  """This Agent chooses Random Legal Move to a place containing food. It moves a different Random Move, if food is not adjacent"""
  def getAction(self, state):
    legalActions = state.getLegalPacmanActions()
    #Checks if Stop is the only option
    legalActions.remove(Directions.STOP)
    if len(legalActions) == 0:
      return Directions.STOP
    else:
      pacmanPosition = state.getPacmanPosition()
      pacmanX = pacmanPosition[0]
      pacmanY = pacmanPosition[1]
      foodPositions = state.getFood()
      #Finds all Legal Moves that lead to Food
      foodMoves = []
      if foodPositions[pacmanX][pacmanY + 1]:
        foodMoves.append(Directions.NORTH)
      if foodPositions[pacmanX][pacmanY -1]:
        foodMoves.append(Directions.SOUTH)
      if foodPositions[pacmanX + 1][pacmanY]:
        foodMoves.append(Directions.EAST)
      if foodPositions[pacmanX - 1][pacmanY]:
        foodMoves.append(Directions.WEST)
      #Chooses a Legal Food Move, if there are any, else chooses a Random Move
      if len(foodMoves) > 0:
        return foodMoves[random.randint(0, len(foodMoves) - 1)]
      else:
        return legalActions[random.randint(0, len(legalActions) - 1)]