import numpy as np

x = np.array([0, 1])
w = np.array([0.5, 0.5])
b = -0.7

v = w * x
print(v)

y = np.sum(w*x) + b
print(y)

# if __name__ == "__main__":
#     y = AND(0, 0)
#     print(y)
#     y = AND(1, 0)
#     print(y)
#     y = AND(0, 1)
#     print(y)
#     y = AND(1, 1)
#     print(y)
