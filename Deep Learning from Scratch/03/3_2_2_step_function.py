
def step_function(x):
    if x > 0:
        return 1
    return 0


if __name__ == "__main__":
    y = step_function(0.3)
    print(y)
