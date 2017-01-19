import sys

def StairCase(n) :
    i = 1 
    while i <= n :
        NoOfspaces = n-i        
        for x in range(NoOfspaces) :
            sys.stdout.write(' ')
        for x in range(i) :
            sys.stdout.write('#')
        sys.stdout.write('\n')
        i += 1
    sys.stdout.flush()
        
_n = int(raw_input())
StairCase(_n)