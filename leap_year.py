def is_leap_year(year):
    return (year % 4 == 0 and year % 100 != 0) or year % 400 == 0


def is_huluculu_year(year):
    return year % 15 == 0


def is_bulukulu_year(year, is_leap=None):
    return year % 55 == 0 and (is_leap or is_leap_year(year))


def main():
    line = input()

    while line != '' and len(line) != 0:
        year = int(line)

        is_leap = False
        is_ordinary = True
        if is_leap_year(year):
            is_leap = True
            is_ordinary = False
            print("This is leap year.")

        if is_huluculu_year(year):
            is_ordinary = False
            print("This is huluculu festival year.")

        if is_bulukulu_year(year, is_leap):
            is_ordinary = False
            print("This is bulukulu festival year.")

        if is_ordinary:
            print("This is an ordinary year.")

        try:
            line = input()
            print()
        except EOFError:
            break


if __name__ == '__main__':
    main()
