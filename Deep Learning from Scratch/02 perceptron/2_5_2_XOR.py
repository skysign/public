import numpy as np
import sys
sys.path.append('.')
from AND_NAND_OR import AND, NAND, OR


def XOR(x1, x2):
    return AND(OR(x1, x2), NAND(x1, x2))


if __name__ == "__main__":
    print('XOR')
    y = XOR(0, 0)
    print(y)
    y = XOR(1, 0)
    print(y)
    y = XOR(0, 1)
    print(y)
    y = OR(1, 1)
    print(y)
    print('--------------------')
