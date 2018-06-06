import numpy as np

def AND(x1, x2):
    x = np.array([x1, x2])
    w = np.array([0.5, 0.5])
    b = -0.7
    tmp = np.sum(w*x) + b

    if tmp <= 0:
        return 0

    return 1


def NAND(x1, x2):
    x = np.array([x1, x2])
    w = np.array([-0.5, -0.5])
    b = 0.7
    tmp = np.sum(w*x) + b

    if tmp <= 0:
        return 0

    return 1


def OR(x1, x2):
    x = np.array([x1, x2])
    w = np.array([0.5, 0.5])
    b = -0.2
    tmp = np.sum(w*x)+b

    if tmp <= 0:
        return 0

    return 1

def XOR(x1, x2):
    return AND(OR(x1, x2), NAND(x1, x2))

if __name__ == "__main__":
    print('AND')
    y = AND(0, 0)
    print(y)
    y = AND(1, 0)
    print(y)
    y = AND(0, 1)
    print(y)
    y = AND(1, 1)
    print(y)
    print('--------------------')

    print('NAND')
    y = NAND(0, 0)
    print(y)
    y = NAND(1, 0)
    print(y)
    y = NAND(0, 1)
    print(y)
    y = NAND(1, 1)
    print(y)
    print('--------------------')

    print('OR')
    y = OR(0, 0)
    print(y)
    y = OR(1, 0)
    print(y)
    y = OR(0, 1)
    print(y)
    y = OR(1, 1)
    print(y)
    print('--------------------')

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
