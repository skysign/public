import numpy as np
import matplotlib.pylab as plt

def sigmoid(x):
    return 1 / (1 + np.exp(-x))

a = np.array([1010, 1000, 990])
np_a = np.exp(a) / np.sum(np.exp(a))
print(np_a)

def softmax(a):
    c = np.max(a)
    exp_a = np.exp(a-c)
    sum_exp_a = np.sum(exp_a)
    y = exp_a / sum_exp_a
    return y

y = softmax(a)
print(y)
sum_y = np.sum(y)
print(sum_y)
