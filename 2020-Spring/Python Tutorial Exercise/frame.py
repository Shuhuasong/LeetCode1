from tkinter import *

window = Tk()

fTop = Frame(window)
fTop.pack()

fBottom = Frame(window)
fBottom.pack(side=BOTTOM)

label1 = Label(fTop, text="Label")
label1.pack(side=LEFT)
label2 = Label(fTop, text="Label2")
label2.pack(side=RIGHT)
label3 = Label(fBottom, text="Label3")
label3.pack()

def handleClick():
    print("Button Clicked")
button1 = Button(window, bd=20, bg='#007700', fg="Green", text="Click Me",
                 padx=50, pady=80, command=handleClick)
button1.place(x=50, y=50)

window.mainloop()
