#! /usr/bin/python

#x = [2,0,2,4]


def slide(x):
        locked = -1
        res = [0,0,0,0]
        res[0] = x[0]
        for src in range(1,4):
                #print("With src=",src," res=",res)
                if x[src] == 0: continue
                dest = src
                while dest > 0 and res[dest-1] == 0:
                        dest = dest - 1
                #print("dest",dest)
                if dest > 0 and res[dest-1] == x[src] and locked != dest-1:
                        res[dest-1] = 2*x[src]
                        locked = dest-1
                        #print("Locked",dest-1)
                else:
                        #print ("Cannot combine or dest=0")
                        res[dest] = x[src]
        return res

tests = [[2,0,2,4],[0,2,2,4],[2,0,0,0],[0,2,0,0],[0,0,2,0],[0,0,0,2],[0,0,0,0],[4,2,2,0],[4,2,0,2],[2,2,2,2],[4,4,4,4],[4,0,0,4],[4,0,0,16],[0,2,4,8],[16,0,2,4],
[0,4,0,4]]
#tests = [[2,0,2,4]]

for x in tests:
        res = slide(x)
        #print(res)
        print (x,res)
