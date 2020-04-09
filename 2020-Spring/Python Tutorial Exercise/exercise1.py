#!/usr/bin/env python3  #Shebang Line
#to find the python interpreter

#!/usr/local/bin/python   absolute path

#print('Hello, World');
#print('something happen here');
#one statement per line

name = '_main_'

import platform

def main():
    message()

def message():
    print('This is python version {}'.format(platform.python_version()))
if  name == '_main_': main()

if False:
    print('false')
else:
    print('true');





