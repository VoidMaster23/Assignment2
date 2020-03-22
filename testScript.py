import subprocess 

n = 297
avlBestArr = []
avlWorstArr = []
avlAvgArr = []

bstBestArr = []
bstWorstArr = []
bstAvgArr = []

for i in range(10):
	print(n)
	avlInsArr = []
	bstInsArr = []

	avlFinArr = []
	bstFinArr = []

	fileN = 'input'+str((i+1))+'.txt'
	f = open('res/'+fileN,'r')
	fl = f.readlines()
	for j in range(len(fl)):
		print(j)
		#extract the key
		key = fl[j].split(" ")[0]
		params = key.split("_")
		
		#run the program 
		p1 = subprocess.run(['java','-cp', 'bin/', 'LSAVLapp', params[0],params[1], params[2], fileN],capture_output = True, text = True)
		
		avlArr = p1.stdout.rstrip("\n").split(" ")
		avlInsArr.append(int(avlArr[1]))
		avlFinArr.append(int(avlArr[0]))
		

		#run BST
		p2 = subprocess.run(['java','-cp', 'bin/', 'LSBSTApp', params[0],params[1], params[2], fileN],capture_output = True, text = True)
		bstArr = p2.stdout.rstrip("\n").split(" ")
		bstInsArr.append(int(bstArr[1]))
		bstFinArr.append(int(bstArr[0]))
		
	avlBestArr.append(min(avlFinArr))
	avlWorstArr.append(max(avlFinArr))
	avlAvgArr.append(sum(avlFinArr)/len(avlFinArr))

	bstBestArr.append(min(bstFinArr))
	bstWorstArr.append(max(bstFinArr))
	bstAvgArr.append(sum(bstFinArr)/len(bstFinArr))

	print("Best AVL for",n,"items:",avlBestArr)
	print("Worst AVL for",n,"items:",avlWorstArr)
	print("AVG AVL for",n,"items:",avlAvgArr)

	print("Best BST for",n,"items:",bstBestArr)
	print("Worst BST for",n,"items:",bstWorstArr)


	


		
	n+= 297
bestAVLOut = open('out/BestAVL.txt','w')
worstAVLOut = open('out/WorstAVL.txt','w')
avgAVLOut = open('out/AvgAVL.txt','w')


bestBSTOut = open('out/BestBST.txt','w')
worstBSTOut = open('out/WorstBST.txt','w')
avgBSTOut = open('out/AvgBST.txt','w')

for i in range(10):
	bestAVLOut.write(str(avlBestArr[i])+", ")
	worstAVLOut.write(str(avlWorstArr[i])+", ")
	avgAVLOut.write(str(avlAvgArr[i])+", ")
	
	bestBSTOut.write(str(bstBestArr[i])+", ")
	worstBSTOut.write(str(bstWorstArr[i])+", ")
	avgBSTOut.write(str(bstAvgArr[i])+", ")

bestAVLOut.close()
worstAVLOut.close()
avgAVLOut.close()

bestBSTOut.close()
worstBSTOut.close()
avgBSTOut.close()

