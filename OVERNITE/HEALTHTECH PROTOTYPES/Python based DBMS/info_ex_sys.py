# -*- coding: utf-8 -*-
"""
Created on Wed Apr  7 20:14:18 2021

@author: Chirantan
"""

import openpyxl

loc = ("HEALTHDATA.xlsx")
wb_obj = openpyxl.load_workbook(loc)
k = wb_obj.active

f = open("demofile.txt", "rt")

class patient:
    flg = 0
    name = f.readline()
    ph = f.readline()
    bloodgr = f.readline()
    dob = f.readline()
    gender = f.readline()
    patid = "null";
    
    def update(X, id_no):
        if id_no != '' :
            X.patid = id_no
        else:
            l1, ln, lp, ld = [], [], [], []
            for i in range(2, k.max_row + 1):
                l1.append(int(k.cell(row = i, column = 1).value))
                ln.append(int(k.cell(row = i, column = 2).value))
                lp.append(int(k.cell(row = i, column = 3).value))
                ld.append(int(k.cell(row = i, column = 5).value))
            
            j = str(max(l1) + 1)
            x = str(j).zfill(4)
            
            if X.name in ln:
                if lp[ln.index(X.name)] == X.ph or ld[ln.index(X.name)] == X.dob:
                    X.patid = l1[ln.index(X.name)]
                    X.flg = 1
                else:
                    X.patid = x
            else:
                X.patid = x
            
Y = patient()
Y.update(f.readline())

f.close();