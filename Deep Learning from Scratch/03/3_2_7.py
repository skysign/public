import numpy as np
import matplotlib.pylab as plt

def sigmoid(x):
    return 1 / (1 + np.exp(-x))

def ReLU(x):
    return np.maximum(0, x)

if __name__ == "__main__":
    x = np.arange(-5.0, 5.0, 0.1)
    y = ReLU(x)
    print(y)
    plt.plot(x, y)
    plt.ylim(-5.1, 5.1)
    plt.show()
