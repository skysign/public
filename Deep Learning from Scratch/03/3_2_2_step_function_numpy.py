import numpy as np

def step_function(x):
    y = x > 0
    return y.astype(np.int)

if __name__ == "__main__":
    y = step_function(np.array([1.0, 2.0, 0]))
    print(y)
