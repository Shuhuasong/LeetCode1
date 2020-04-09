from tkinter import *

window = Tk()

navigator = Menu(window)
window.config(menu=navigator)

#add 'File' on the navigator bar

def test():
    print("test")
fileMenu = Menu(navigator, tearoff=0)

#add some options on File

fileMenu.add_command(label="New", command=test)
fileMenu.add_command(label="Open", command=test)
fileMenu.add_command(label="Save", command=test)
fileMenu.add_separator()
fileMenu.add_command(label="Close", command=test)
navigator.add_cascade(label="File", menu=fileMenu)


editMenu=Menu(navigator)
navigator.add_cascade(label="Edit", menu=editMenu)
editMenu.add_command(label="Undo")
editMenu.add_command(label="Redo")
editMenu.add_command(label="Copy")
editMenu.add_command(label="Delete")

helpMenu=Menu(navigator)
navigator.add_cascade(label="Help", menu=helpMenu)

#create canvas

canvas = Canvas(window, width=300, height=200)
canvas.pack()
canvas.create_line(0,0,300,200, fill="Red")
canvas.create_line( 0,200, 300, 0, fill="Green")

#create Rectangle
canvas.create_rectangle(80, 60, 220, 140, fill="Green")
canvas.create_rectangle(100, 80, 200, 120, fill="Red")
canvas.create_oval(140, 100, 160, 110, fill="Black")
window.mainloop()