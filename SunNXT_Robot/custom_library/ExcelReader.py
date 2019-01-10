import openpyxl
import xlrd
from robot.api.deco import keyword


class ExcelReader(object):
    _author_ = "Ameet Kumar Pradhan"
    _copyright_ = "Copyright (C) 2018 Ameet Kumar Pradhan"
    _version_ = 0.4
    ROBOT_EXIT_ON_FAILURE = True
    file_name = str('')

    @keyword
    def choose_excel_sheet(self, file_path):
        workbook = xlrd.open_workbook(file_path)
        total_sheets = workbook.nsheets
        sheet_names = workbook.sheet_names()
        for sheets in range(0, total_sheets):
            current_sheet = sheet_names[sheets]
            worksheet = workbook.sheet_by_index(sheets)
            first_row = []
            for col in range(worksheet.ncols):
                first_row.append(worksheet.cell_value(1, col))
            data = []
            for row in range(2, worksheet.nrows):
                elem = {}
                for col in range(worksheet.ncols):
                    if worksheet.cell_value(row, col) == '':
                        break
                    else:
                        elem[first_row[col]] = worksheet.cell_value(row, col)
                data.append(elem)
            file_name = list(filter(None, data))
            globals()["file_name-" + str(current_sheet)] = file_name
            print(globals()["file_name-" + str(current_sheet)])

    @keyword
    def get_value_from_corresponding_row(self, sheet_name, primary_key_header, primary_key, value_fetcher_header):
        dict_length = len(globals()["file_name-" + str(sheet_name)])
        for fetch_data in range(0, dict_length):
                if globals()["file_name-" + str(sheet_name)][fetch_data].get(primary_key_header) == primary_key:
                    value = globals()["file_name-" + str(sheet_name)][fetch_data].get(value_fetcher_header)
                    print(value)
                    if isinstance(value, float):
                        value = int(value)
                        if value < 10:
                            value = "%02d" % (value,)
                    return value
                else:
                    continue

    @keyword
    def edit_a_cell_and_save_file(self, file_path, sheet_name, row_num, col_num, new_val):
        workbook = openpyxl.load_workbook(file_path)
        worksheet = workbook[sheet_name]
        row_num = int(row_num)
        col_num = int(col_num)
        worksheet.cell(row=row_num, column=col_num).value = new_val
        workbook.save(filename=file_path)

