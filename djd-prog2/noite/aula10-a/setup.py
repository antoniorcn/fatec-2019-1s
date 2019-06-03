import cx_Freeze
import os

os.environ['TCL_LIBRARY'] = r'C:\Python37\tcl\tcl8.6'
os.environ['TK_LIBRARY'] = r'C:\Python37\tcl\tk8.6'

executables = [cx_Freeze.Executable("teste_sprite_projetil.py")]

cx_Freeze.setup(
    name="A bit Racey",
    options={"build_exe": {"packages":["pygame"],
                           "include_files":["images/EpicArmor.png"]}},
    executables = executables

    )