import os
import sys

library_path = os.getcwd()
sys.path.insert(0, library_path)
sys.path.append(library_path)
print(sys.path)
