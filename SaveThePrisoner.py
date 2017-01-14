# -*- coding: utf-8 -*-
'''A jail has  prisoners, and each prisoner has a unique id number, s, ranging from 1 to n . 
There are  sweets that must be distributed to the prisoners.

The jailer decides the fairest way to do this is by sitting the prisoners down in a circle (ordered by ascending ), 
and then, starting with some random , distribute one candy at a time to each sequentially numbered prisoner until all  candies are distributed. For example, if the jailer picks prisoner , then his distribution order would be  until all  sweets are distributed.

But wait—there's a catch—the very last sweet is poisoned! 
Can you find and print the ID number of the last prisoner to 
receive a sweet so he can be warned?

Input Format

The first line contains an integer, t, denoting the number of test cases. 
The  subsequent lines each contain  space-separated integers: 
 N(the number of prisoners),M  (the number of sweets), and  S(the prisoner ID), respectively.
'''

f1 = open('SaveThePrisonerTestCase','r')
f2 = open('SaveThePrisonerTestCaseOutput','r')

T = int(f1.readline())
for testcases in range(T) :
    N , M , S = map(int, f1.readline().strip().split(' '))
    ans = int(f2.readline())
    if M == 0 :
        print 0
    M = M%N
    personAffected = S + M - 1
    if personAffected > N :
        personAffected %= N
    if personAffected == 0 :
        personAffected = N
    if personAffected != ans :
        print "My answer = %s actual answer = %s" % (personAffected,ans)
    
    
    
