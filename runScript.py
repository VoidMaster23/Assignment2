import subprocess

n = 297;
inFiles = ['input1.txt', 'input2.txt', 'input3.txt', 'input4.txt', 'input5.txt','input6.txt','input7.txt','input8.txt','input9.txt','input10.txt',]

for i in range(10):
    p1 = subprocess.run(['shuf','-n',str(n),'../res/Load_Shedding_All_Areas_Schedule_and_Map.clean.final.txt'], capture_output=True, text=True)

    with open("../res/"+inFiles[i], 'w') as f:
        f.write(p1.stdout)
    
    n += 297

