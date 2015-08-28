#! /usr/local/bin/python

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

board = [i for i in range(16)]
print(board)

def pretty_print(b):
	print(" %5d %5d %5d %5d\n %5d %5d %5d %5d\n %5d %5d %5d %5d\n %5d %5d %5d %5d\n" % tuple(b))
	  #(b.tolist()))
pretty_print(board)

starts = {"left" : [0,4,8,12], "up" : [0,1,2,3], "right" : [3,7,11,15], "down" : [12,13,14,15]}
offsets = {"left" : 1, "up" : 4, "right" : -1, "down" : -4}
ssize = 4
def to_slider(board, start, offset):
	slider = [0,0,0,0]
	for i in range(ssize):
		slider[i] = board[start+i*offset]
	return slider

def from_slider(board, slider, start, offset):
	for i in range(ssize):
		board[start+i*offset] = slider[i]

dirs = ["left","right","up","down"]
for dir in dirs:
	print(dir)
	for i in range(ssize):
		print(i)
		print(to_slider(board, starts[dir][i], offsets[dir]))

for dir in dirs:
	print(dir)
	for i in range(ssize):
		cboard = board[:]
		slider = [0,0,0,0]
		print(i)
		from_slider(cboard, slider, starts[dir][i], offsets[dir])
		pretty_print(cboard)
