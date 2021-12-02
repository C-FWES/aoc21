def greater_than_previous(measurements: list):
    count = 0
    windows = []
    for i in range(len(measurements)-2):
        windows.append(measurements[i] + measurements[i+1] + measurements[i+2])
    for i in range(len(windows)-1):
        if windows[i] < windows[i+1]:
            count += 1
        i += 1
    return count


measurements = []
measurements2 = []
while True:
    line = input()
    if line:
        measurements.append(line)
    else:
        break
for m in measurements:
    measurements2.append(int(m))
number_of_times = greater_than_previous(measurements2)
print(number_of_times)

