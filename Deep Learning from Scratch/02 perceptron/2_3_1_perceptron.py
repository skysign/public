def AND(x1, x2):
    w1, w2, theta = 0.5, 0.5, 0.7
    tmp = x1*w1 + x2*w2

    if tmp <= theta:
        return 0
    elif tmp > theta:
        return 1

    return 0

if __name__ == "__main__":
    y = AND(0, 0)
    print(y)
    y = AND(1, 0)
    print(y)
    y = AND(0, 1)
    print(y)
    y = AND(1, 1)
    print(y)
