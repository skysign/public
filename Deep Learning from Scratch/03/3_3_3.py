import numpy as np
import matplotlib.pylab as plt

def sigmoid(x):
    return 1 / (1 + np.exp(-x))

x = np.array([1, 2])
print(x.shape)

w = np.array([[1,3,5], [2,4,6]])
print(w)
print(w.shape)
y = np.dot(x, w)
print(y)
