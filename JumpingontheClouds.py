'''
Aerith is playing a cloud game! In this game, there are  clouds numbered sequentially 
from 0 to n-1. Each cloud is either an ordinary cloud or a thundercloud.

Aerith starts out on cloud  with energy level E = 100
. She can use 1 unit of energy to make a jump of size k to (i+k)%n cloud , 
and she jumps until she gets back to cloud 0. 
If Aerith lands on a thundercloud, her energy (E) decreases by 2 additional units. 
The game ends when Aerith lands back on cloud 0.

Given the values of n, k, and the configuration of the clouds, 
can you determine the final value of E after the game ends?


Input Format

The first line contains two space-separated integers, n 
(the number of clouds) and  k(the jump distance), respectively. 
The second line contains  space-separated integers describing the respective values of clouds .
Each cloud is described as follows: c0, c1, ... cn-1

If ci = 0, then cloud  is an ordinary cloud.
If ci = 1, then cloud  is a thundercloud.

Sample Input
8 2
0 0 1 0 0 1 1 0

Sample Output
92

#!/bin/python
'''

import sys

def reduceEnergy(cloudType,E) : 
    E = E-1 if cloudType == 0 else E-3
    return E

def findEnergyLeft(n,k,c,E=100) :
    ind = 0
    cloudType = c[ind]
    E = reduceEnergy(cloudType,E)
    ind += k
    ind = ind%(n)
    while ind != 0 and E != 0:
        cloudType = c[ind]
        E = reduceEnergy(cloudType,E)
        ind += k
        ind = ind%(n) 
    return E     
    

n,k = raw_input().strip().split(' ')
n,k = [int(n),int(k)]
c = map(int,raw_input().strip().split(' '))

print findEnergyLeft(n,k,c,100)