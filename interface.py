import tkinter
from zeep import Client


class simpleapp_tk(tkinter.Tk):
    def __init__(self,parent):
        tkinter.Tk.__init__(self,parent)
        self.parent = parent
        self.initialize()

    def initialize(self):
        self.grid()
        self.geometry("500x500")
#---------------------------------------------------------------------------------------------------------------#
        self.labelVariable1 = tkinter.StringVar()
        label1 = tkinter.Label(self, textvariable=self.labelVariable1, height=2,anchor="w", fg="black")
        label1.grid(column=0, row=0, columnspan=2, sticky='n')
        self.labelVariable1.set(u"Hello !")

        button1 = tkinter.Button(self, text=u"get All users !", command=self.OnButtonClick1)
        button1.grid(column=0, row=1)

        self.labelVariable = tkinter.StringVar()
        label = tkinter.Label(self, textvariable=self.labelVariable,height=2,relief='sunken', anchor="w", fg="black",bg="#BAFFDB")
        label.grid(column=0, row=2, columnspan=2, sticky='EW')

        self.labelVariable5 = tkinter.StringVar()
        label5 = tkinter.Label(self, textvariable=self.labelVariable5, anchor="w", fg="green")
        label5.grid(column=0, row=3, columnspan=2, sticky='EW')
#----------------------------------------------------------------------------------------------------------------#
        self.labelVariable2 = tkinter.StringVar()
        label2 = tkinter.Label(self, textvariable=self.labelVariable2, anchor="w", fg="green")
        label2.grid(column=0, row=4, columnspan=2, sticky='EW')
        self.labelVariable2.set(u"entrez les informations d'un utilisateur !")

        self.entryVariable2 = tkinter.StringVar()
        self.entry2 = tkinter.Entry(self, textvariable=self.entryVariable2)
        self.entry2.grid(column=0, row=5, sticky='EW')
        self.entry2.bind("<Return>", self.OnPressEnter)
        self.entryVariable2.set(u"ID.")

        self.entryVariable3 = tkinter.StringVar()
        self.entry3 = tkinter.Entry(self, textvariable=self.entryVariable3)
        self.entry3.grid(column=0, row=6, sticky='EW')
        self.entry3.bind("<Return>", self.OnPressEnter)
        self.entryVariable3.set(u"firstname.")

        self.entryVariable4 = tkinter.StringVar()
        self.entry4 = tkinter.Entry(self, textvariable=self.entryVariable4)
        self.entry4.grid(column=0, row=7, sticky='EW')
        self.entry4.bind("<Return>", self.OnPressEnter)
        self.entryVariable4.set(u"Lastname.")

        self.entryVariable5 = tkinter.StringVar()
        self.entry5 = tkinter.Entry(self, textvariable=self.entryVariable5)
        self.entry5.grid(column=0, row=8, sticky='EW')
        self.entry5.bind("<Return>", self.OnPressEnter)
        self.entryVariable5.set(u"birthdate.")

        button2 = tkinter.Button(self, text=u"set user !", command=self.OnButtonClick2)
        button2.grid(column=0, row=9)


#-----------------------------------------------------------------------------------------------------------------
        self.labelVariable3 = tkinter.StringVar()
        label3 = tkinter.Label(self, textvariable=self.labelVariable3, anchor="w", fg="red")
        label3.grid(column=0, row=10, columnspan=2, sticky='EW')
        self.labelVariable3.set(u"Supprimer un utilisateur !")

        self.entryVariable6 = tkinter.StringVar()
        self.entry6 = tkinter.Entry(self, textvariable=self.entryVariable6)
        self.entry6.grid(column=0, row=11, sticky='EW')
        self.entry6.bind("<Return>", self.OnPressEnter)
        self.entryVariable6.set(u"ID.")

        button3 = tkinter.Button(self, text=u"delete user !", command=self.OnButtonClick3)
        button3.grid(column=0, row=12)


#------------------------------------------------------------------------------------------------------------------
        self.labelVariable4 = tkinter.StringVar()
        label4 = tkinter.Label(self, textvariable=self.labelVariable4, anchor="w", fg="blue")
        label4.grid(column=0, row=13, columnspan=2, sticky='EW')
        self.labelVariable4.set(u"Modifiez les informations d'un utilisateur !")

        self.entryVariable7 = tkinter.StringVar()
        self.entry7 = tkinter.Entry(self, textvariable=self.entryVariable7)
        self.entry7.grid(column=0, row=14, sticky='EW')
        self.entry7.bind("<Return>", self.OnPressEnter)
        self.entryVariable7.set(u"ID.")

        self.entryVariable8 = tkinter.StringVar()
        self.entry8 = tkinter.Entry(self, textvariable=self.entryVariable8)
        self.entry8.grid(column=0, row=15, sticky='EW')
        self.entry8.bind("<Return>", self.OnPressEnter)
        self.entryVariable8.set(u"firstname.")

        self.entryVariable9 = tkinter.StringVar()
        self.entry9 = tkinter.Entry(self, textvariable=self.entryVariable9)
        self.entry9.grid(column=0, row=16, sticky='EW')
        self.entry9.bind("<Return>", self.OnPressEnter)
        self.entryVariable9.set(u"Lastname.")

        self.entryVariable10 = tkinter.StringVar()
        self.entry10 = tkinter.Entry(self, textvariable=self.entryVariable10)
        self.entry10.grid(column=0, row=17, sticky='EW')
        self.entry10.bind("<Return>", self.OnPressEnter)
        self.entryVariable10.set(u"birthdate.")

        button4 = tkinter.Button(self, text=u"update user !", command=self.OnButtonClick4)
        button4.grid(column=0, row=18)
#------------------------------------------------------------------------------------------------------------------

        self.grid_columnconfigure(0,weight=1)
        self.resizable(True,True)
        self.update()

    def OnButtonClick1(self):
        client = Client("C:\\Users\\Bensammar\\eclipse-workspace\\axisTest\\WebContent\\wsdl\\hello.wsdl")
        result1 = client.service.getCustomer()
        self.labelVariable.set(result1)

    def OnButtonClick2(self):
        client = Client("C:\\Users\\Bensammar\\eclipse-workspace\\axisTest\\WebContent\\wsdl\\hello.wsdl")
        result1 = client.service.setCustomer(self.entryVariable2.get(), self.entryVariable3.get(),
                                             self.entryVariable4.get(), self.entryVariable5.get())

        #self.labelVariable.set( self.entryVariable2.get()+" (You clicked the button)" )
        self.entry2.focus_set()
        self.entry2.selection_range(0, tkinter.END)

    def OnButtonClick3(self):
        client = Client("C:\\Users\\Bensammar\\eclipse-workspace\\axisTest\\WebContent\\wsdl\\hello.wsdl")
        result1 = client.service.deleteCustomer(self.entryVariable6.get())

        #self.labelVariable.set( self.entryVariable6.get()+" (You clicked the button)" )
        self.entry6.focus_set()
        self.entry6.selection_range(0, tkinter.END)

    def OnButtonClick4(self):
        client = Client("C:\\Users\\Bensammar\\eclipse-workspace\\axisTest\\WebContent\\wsdl\\hello.wsdl")
        result1 = client.service.updateCustomer(self.entryVariable7.get(), self.entryVariable8.get(),
                                             self.entryVariable9.get(), self.entryVariable10.get())

        #self.labelVariable.set( self.entryVariable.get()+" (You clicked the button)" )
        self.entry7.focus_set()
        self.entry7.selection_range(0, tkinter.END)

    def OnPressEnter(self,event):
        self.labelVariable.set( self.entryVariable.get()+" (You pressed ENTER)" )
        self.entry.focus_set()
        self.entry.selection_range(0, tkinter.END)

if __name__ == "__main__":
    app = simpleapp_tk(None)
    app.title('my application')
    app.mainloop()