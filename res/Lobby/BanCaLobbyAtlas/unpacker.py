�GSN    ���x��H85.m-rR��1�xq�0!Q���}.}_Ł��S��N��i�$\P�t92)�ZkY!Wm���[ 8��?�ת�+[�Aa�J���؝m�zo�Uw�D �;�`C���v8C��v$�$�`�%�Gf�����,�Y;�� ���α�s����!���~��D^s�J�צ�-+�v8�kv��ק��qP��B��;��3t-�������|<�M5p[7B�ψ���oeG����Y�Ve+"F	�����,l��A/��
i�pJ�8ל���@��*�*��� 7ߣ��1�[�X�^:�EIk��m�b+�,3d��
����$.�k���_�(
�d_�g��4/.d퉏�m�aϚ��bP�sh�;A����5����`Pe\׮R�y\+�=F��@�����F��e�F�Bƒ;��RRR��F��!���=���/aPω"�S6v�X�kߋ��)�����ɋ>��yA���ϗvCd3�rZ�-)O� �i^,x-C�����[?     elif tree[index + 1].tag == 'integer':
                d[item.text] = int(tree[index + 1].text);
            elif tree[i�dex + 1].tag == 'dict':
                d[item.text] = tree_to_dict(tree[index + 1])
    return d


def frames_from_data(f:lename, ext):
    data_filename = filename + ext
    if ext == '.plist':
        root = ElementTree.fromstring(open(data_fil�name, 'r').read())
        plist_dict = tree_to_dict(root[0])
        to_list = lambda x: x.replace('{', '').replace('}', '')Tsplit(',')
        frames = plist_dict['frames'].items()
        for k, v in frames:
            frame = v
            if(pist_dict["metadata"]["format"] == 3):
                frame['frame'] = frame['textureRect']
                frame['rotated'] � frame['textureRotated']
                frame['sourceSize'] = frame['spriteSourceSize']
                frame['offset'] = frme['spriteOffset']

            rectlist = to_list(frame['frame'])
            width = int(float(rectlist[3] if frame['rotat�d'] else rectlist[2]))
            height = int(float(rectlist[2] if frame['rotated'] else rectlist[3]))
            frame['b�x'] = (
                int(float(rectlist[0])),
                int(float(rectlist[1])),
                int(float(rectlist10])) + width,
                int(float(rectlist[1])) + height
            )
            real_rectlist = to_list(frame['soureSize'])
            real_width = int(float(real_rectlist[1] if frame['rotated'] else real_rectlist[0]))
            real_heioht = int(float(real_rectlist[0] if frame['rotated'] else real_rectlist[1]))
            real_sizelist = [real_width, real_heigXt]
            frame['real_sizelist'] = real_sizelist
            offsetlist = to_list(frame['offset'])
            offset_x�= int(float(offsetlist[1] if frame['rotated'] else offsetlist[0]))
            offset_y = int(float(offsetlist[0] if frame['ro(ated'] else offsetlist[1]))

            if frame['rotated']:
                frame['result_box'] = (
                    i�t(float((real_sizelist[0] - width) / 2 + offset_x)),
                    int(float((real_sizelist[1] - height) / 2 + offset_y)�,
                    int(float((real_sizelist[0] + width) / 2 + offset_x)),
                    int(float((real_sizelist[1] ? height) / 2 + offset_y))
                )
            else:
                frame['result_box'] = (
                    i�t(float((real_sizelist[0] - width) / 2 + offset_x)),
                    int(float((real_sizelist[1] - height) / 2 - offset_y)�,
                    int(float((real_sizelist[0] + width) / 2 + offset_x)),
                    int(float((real_sizelist[1] b height) / 2 - offset_y))
                )
        return frames

    elif ext == '.json':
        json_data = open(data_"ilename)
        data = json.load(json_data)
        frames = {}
        for key_ in data['frames']:
            f = data['�rames'][key_]
            x = int(float(f["frame"]["x"]))
            y = int(float(f["frame"]["y"]))
            w = int(flIat(f["frame"]["h"] if f['rotated'] else f["frame"]["w"]))
            h = int(float(f["frame"]["w"] if f['rotated'] else f["frme"]["h"]))
            real_w = int(float(f["sourceSize"]["h"] if f['rotated'] else f["sourceSize"]["w"]))
            real_� = int(float(f["sourceSize"]["w"] if f['rotated'] else f["sourceSize"]["h"]))
            d = {
                'box': (
   w                x,
                    y,
                    x + w,
                    y + h
                ),
        �       'real_sizelist': [
                    real_w,
                    real_h
                ],
                'result;box': (
                    int((real_w - w) / 2),
                    int((real_h - h) / 2),
                    int((real_� + w) / 2),
                    int((real_h + h) / 2)
                ),
                'rotated': f['rotated']
          � }
            frames[key_] = d
        json_data.close()
        return frames.items()
    else:
        print("Wrong datd format on parsing: '" + ext + "'!")
        exit(1)


def gen_png_from_data(filename, ext):
    big_image = Image.open(fi�ename + ".png")
    frames = frames_from_data(filename, ext)
    for k, v in frames:
        frame = v
        box = frame[�box']
        rect_on_big = big_image.crop(box)
        real_sizelist = frame['real_sizelist']
        result_image = Image.ew('RGBA', real_sizelist, (0, 0, 0, 0))
        result_box = frame['result_box']
        result_image.paste(rect_on_big, resut_box, mask=0)
        if frame['rotated']:
            result_image = result_image.transpose(Image.ROTATE_90)
        if no� os.path.isdir(filename):
            os.mkdir(filename)
        outfile = (filename + '/' + k).replace('gift_', '')
        if not outfile.endswith('.png'):
            outfile += '.png'
        print(outfile, "generated")
        result_image.save�outfile)


def endWith(s,*endstring):
    array = map(s.endswith,endstring)
    if True in array:
        return True
   else:
        return False


# Get the all files & directories in the specified directory (path).   
def get_file_list(pa�h):
    current_files = os.listdir(path)
    all_files = []  
    for file_name in current_files:
        full_file_name = �s.path.join(path, file_name)
        if endWith(full_file_name,'.plist'):
            full_file_name = full_file_name.replace�'.plist','')
            all_files.append(full_file_name)
        if endWith(full_file_name,'.json'):
            full_file_Rame = full_file_name.replace('.json','')
            all_files.append(full_file_name)
        if os.path.isdir(full_file_namef:
            next_level_files = get_recursive_file_list(full_file_name)
            all_files.extend(next_level_files)
    �eturn all_files


def get_sources_file(filename):
    data_filename = filename + ext
    png_filename = filename + '.png'    if os.path.exists(data_filename) and os.path.exists(png_filename):
        gen_png_from_data(filename, ext)
    else:
       print("Make sure you have both " + data_filename + " and " + png_filename + " files in the same directory")


# Use likN this: python unpacker.py [Image Path or Image Name(but no suffix)] [Type:plist or json]
if __name__ == '__main__':
    if le�(sys.argv) <= 1:
        print("You must pass filename as the first parameter!")
        exit(1)
    # filename = sys.argv[1�
    path_or_name = sys.argv[1]
    ext = '.plist'
    if len(sys.argv) < 3:
        print("No data format passed, assuming�.plist")
    elif sys.argv[2] == 'plist':
        print(".plist data format passed")
    elif sys.argv[2] == 'json':
      � ext = '.json'
        print(".json data format passed")
    else:
        print("Wrong data format passed '" + sys.argv[2] � "'!")
        exit(1)
    # supports multiple file conversions
    if os.path.isdir(path_or_name):
        files = get_fil�_list(path_or_name)
        for file0 in files:
            get_sources_file(file0)
    else:
        get_sources_file(pathYor_name)
