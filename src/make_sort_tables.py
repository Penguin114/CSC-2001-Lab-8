from docx import Document
from docx.shared import Inches, Pt
from docx.enum.text import WD_ALIGN_PARAGRAPH
from docx.enum.table import WD_TABLE_ALIGNMENT, WD_CELL_VERTICAL_ALIGNMENT
from docx.oxml import OxmlElement
from docx.oxml.ns import qn

doc = Document()
sec = doc.sections[0]
sec.top_margin = Inches(.55)
sec.bottom_margin = Inches(.55)
sec.left_margin = Inches(.45)
sec.right_margin = Inches(.45)
normal = doc.styles['Normal']
normal.font.name = 'Times New Roman'
normal.font.size = Pt(9)
normal.paragraph_format.space_after = Pt(0)
widths = [1.70, 1.02, 1.27, 1.02, 1.27, 1.27]
sizes = ['1,000 (integar values)', '2,000 (integar values)', '4,000 (integar values)', '8,000 (integar values)', '16,000 (integar values)', '32,000 (integar values)', '100,000 (estimated)', '500,000 (estimated)']

def make_table(state):
    table = doc.add_table(rows=10, cols=6)
    table.alignment = WD_TABLE_ALIGNMENT.CENTER
    table.autofit = False
    table.style = 'Table Grid'
    for i, col in enumerate(table.columns):
        col.width = Inches(widths[i])
    for row in table.rows:
        for i, cell in enumerate(row.cells):
            cell.width = Inches(widths[i])
            cell.vertical_alignment = WD_CELL_VERTICAL_ALIGNMENT.CENTER
            tcPr = cell._tc.get_or_add_tcPr()
            margins = OxmlElement('w:tcMar')
            for side, n in [('top', 45), ('bottom', 45), ('left', 50), ('right', 50)]:
                el = OxmlElement('w:' + side)
                el.set(qn('w:w'), str(n)); el.set(qn('w:type'), 'dxa'); margins.append(el)
            tcPr.append(margins)
    table.cell(0, 1).merge(table.cell(0, 2))
    table.cell(0, 3).merge(table.cell(0, 4))
    for col, value in [(1, f'Insersion Sort ({state} List)'), (3, f'Merge Sort ({state} List)'), (5, 'Arrays.sort(array)')]:
        table.cell(0, col).text = value
    for col, value in enumerate(['array Size', 'Comparisons', 'Time (seconds)', 'Comparisons', 'Time (seconds)', 'Time (seconds)']):
        table.cell(1, col).text = value
    for i, label in enumerate(sizes, 2):
        table.cell(i, 0).text = label
    for ri, row in enumerate(table.rows):
        for ci, cell in enumerate(row.cells):
            for p in cell.paragraphs:
                p.alignment = WD_ALIGN_PARAGRAPH.CENTER if ri == 0 else WD_ALIGN_PARAGRAPH.LEFT
                for run in p.runs:
                    run.font.name = 'Times New Roman'
                    run.font.size = Pt(9)
                    run.bold = True
    return table

make_table('Sorted')
p = doc.add_paragraph()
p.paragraph_format.space_after = Pt(0)
p.paragraph_format.line_spacing = Pt(12)
make_table('UnSorted')
doc.save('sorting_tables.docx')
