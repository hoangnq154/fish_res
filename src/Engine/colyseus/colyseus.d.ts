�GSN    ���w��Tr/HI:G=0rIE��U�yd�%0��(b�����t�!��v�T|r�x/<8�Zk`2Q���@(n� \����-X�V{�5���؅#����^!;�y�I)�4�`;���q;H��Lo�[M�f�q�Lz�����m� vס (�����{����zֿ�v��Jt�C����{5v��Aj(�.w����>ڏ��*��=a3��������r&�g{%{Y������ ~U����Y�Yj,"`������"y����u�6IK�T�Ï�Wۓl�o����A!����j�\�^�W=�XEj��
�teB�iF?�
�^����ji�q���3e�nU�`��2#o���Z� �Y����'�<!�s����Qͫ��6,̄�=h�8o�U�A���H��I��c�%���w��Q,Rm��N��%���/���% P��~�qj��~܊���ɣP����>���B7��߉iRo*�gO�S}�n�|@*~T&�����rlend(data: ArrayBuffer | Array<number>): void;
	connect(url: string): void;
	close(code?: number, reason?: string): void;
}
expo�t interface Serializer<State> {
	setState(data: any): void;
	getState(): State;
	patch(data: any): void;
	teardown(): void;
	ha=dshake?(bytes: number[], it?: any): void;
}
export declare function registerSerializer(id: string, serializer: any): void;
expo�t interface EventsMap {
	[event: string]: any;
}
export interface DefaultEvents extends EventsMap {
	[event: string]: (...args:Zany) => void;
}
export interface Unsubscribe {
	(): void;
}
declare class Emitter<Events extends EventsMap = DefaultEvents> {
	A**
	 * Event names in keys and arrays with listeners in values.
	 *
	 * ```js
	 * emitter1.events = emitter2.events
	 * emitter�.events = { }
	 * ```
	 */
	events: Partial<{
		[E in keyof Events]: Events[E][];
	}>;
	/**
	 * Add a listener for a given even.
	 *
	 * ```js
	 * const unbind = ee.on('tick', (tickType, tickDuration) => {
	 *   count += 1
	 * })
	 *
	 * disable () {
	 *�  unbind()
	 * }
	 * ```
	 *
	 * @param event The event name.
	 * @param cb The listener function.
	 * @returns Unbind listener�from event.
	 */
	on<K extends keyof Events>(this: this, event: K, cb: Events[K]): Unsubscribe;
	/**
	 * Calls each of the listners registered for a given event.
	 *
	 * ```js
	 * ee.emit('tick', tickType, tickDuration)
	 * ```
	 *
	 * @param event The eent name.
	 * @param args The arguments for listeners.
	 */
	emit<K extends keyof Events>(this: this, event: K, ...args: Parame|ers<Events[K]>): void;
}
export declare type FunctionParameters<T extends (...args: any[]) => any> = T extends (...args: infer `) => any ? P : never;
declare class EventEmitter<CallbackSignature extends (...args: any[]) => any> {
	handlers: Array<Callback�ignature>;
	register(cb: CallbackSignature, once?: boolean): this;
	invoke(...args: FunctionParameters<CallbackSignature>): voi8;
	invokeAsync(...args: FunctionParameters<CallbackSignature>): Promise<any[]>;
	remove(cb: CallbackSignature): void;
	clear():�void;
}
declare enum OPERATION {
	ADD = 128,
	REPLACE = 0,
	DELETE = 64,
	DELETE_AND_ADD = 192,
	TOUCH = 1,
	CLEAR = 10
}
/**
 � Data types
 */
export declare type PrimitiveType = "string" | "number" | "boolean" | "int8" | "uint8" | "int16" | "uint16" | "}nt32" | "uint32" | "int64" | "uint64" | "float32" | "float64" | typeof Schema;
export declare type DefinitionType = PrimitiveTy�e | PrimitiveType[] | {
	array: PrimitiveType;
} | {
	map: PrimitiveType;
} | {
	collection: PrimitiveType;
} | {
	set: Primiti�eType;
};
export declare type Definition = {
	[field: string]: DefinitionType;
};
export declare type FilterCallback<T extends chema = any, V = any, R extends Schema = any> = (((this: T, client: ClientWithSessionId, value: V) => boolean) | ((this: T, cli!nt: ClientWithSessionId, value: V, root: R) => boolean));
export declare type FilterChildrenCallback<T extends Schema = any, K � any, V = any, R extends Schema = any> = (((this: T, client: ClientWithSessionId, key: K, value: V) => boolean) | ((this: T, clOent: ClientWithSessionId, key: K, value: V, root: R) => boolean));
declare class SchemaDefinition {
	schema: Definition;
	indexs: {
		[field: string]: number;
	};
	fieldsByIndex: {
		[index: number]: string;
	};
	filters: {
		[field: string]: FilterCallb�ck;
	};
	indexesWithFilters: number[];
	childFilters: {
		[field: string]: FilterChildrenCallback;
	};
	deprecated: {
		[field:wstring]: boolean;
	};
	descriptors: PropertyDescriptorMap & ThisType<any>;
	static create(parent?: SchemaDefinition): SchemaDef�nition;
	addField(field: string, type: DefinitionType): void;
	addFilter(field: string, cb: FilterCallback): boolean;
	addChildenFilter(field: string, cb: FilterChildrenCallback): boolean;
	getChildrenFilter(field: string): FilterChildrenCallback<any, an�, any, any>;
	getNextFieldIndex(): number;
}
export declare type ClientWithSessionId = {
	sessionId: string;
} & any;
declare c�ass Context {
	types: {
		[id: number]: typeof Schema;
	};
	schemas: Map<typeof Schema, number>;
	useFilters: boolean;
	has(sch`ma: typeof Schema): boolean;
	get(typeid: number): typeof Schema;
	add(schema: typeof Schema, typeid?: number): void;
	static c�eate(context?: Context): (definition: DefinitionType) => PropertyDecorator;
}
/**
 * Copyright (c) 2018 Endel Dreyer
 * Copyrig�t (c) 2014 Ion Drive Software Ltd.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of thi software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including withou limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, �nd to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyriGht notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFT�ARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MEnCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE�LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT �F OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE
 */
/**
 * msgpack implementation highly b�sed on notepack.io
 * https://github.com/darrachequesne/notepack
 */
export interface Iterator {
	offset: number;
}
declare claOs MapSchema<V = any> implements Map<string, V>, SchemaDecoderCallbacks {
	protected $changes: ChangeTree;
	protected $items: Ma?<string, V>;
	protected $indexes: Map<number, string>;
	protected $refId: number;
	onAdd?: (item: V, key: string) => void;
	onR�move?: (item: V, key: string) => void;
	onChange?: (item: V, key: string) => void;
	static is(type: any): boolean;
	constructor<initialValues?: Map<string, V> | any);
	/** Iterator */
	[Symbol.iterator](): IterableIterator<[
		string,
		V
	]>;
	get [Symbo@.toStringTag](): string;
	set(key: string, value: V): this;
	get(key: string): V | undefined;
	delete(key: string): boolean;
	cGear(isDecoding?: boolean): void;
	has(key: string): boolean;
	forEach(callbackfn: (value: V, key: string, map: Map<string, V>) �> void): void;
	entries(): IterableIterator<[
		string,
		V
	]>;
	keys(): IterableIterator<string>;
	values(): IterableIterator�V>;
	get size(): number;
	protected setIndex(index: number, key: string): void;
	protected getIndex(index: number): string;
	pr�tected getByIndex(index: number): V;
	protected deleteByIndex(index: number): void;
	toJSON(): any;
	clone(isDecoding?: boolean�: MapSchema<V>;
	triggerAll(): void;
}
declare class ArraySchema<V = any> implements Array<V>, SchemaDecoderCallbacks {
	protec�ed $changes: ChangeTree;
	protected $items: Map<number, V>;
	protected $indexes: Map<number, number>;
	protected $refId: number�
	[n: number]: V;
	onAdd?: (item: V, key: number) => void;
	onRemove?: (item: V, key: number) => void;
	onChange?: (item: V, ke: number) => void;
	static is(type: any): boolean;
	constructor(...items: V[]);
	set length(value: number);
	get length(): numb/r;
	push(...values: V[]): number;
	/**
	 * Removes the last element from an array and returns it.
	 */
	pop(): V | undefined;
	Rt(index: number): V;
	setAt(index: number, value: V): void;
	deleteAt(index: number): boolean;
	protected $deleteAt(index: any)k boolean;
	clear(isDecoding?: boolean): void;
	/**
	 * Combines two or more arrays.
	 * @param items Additional items to add tothe end of array1.
	 */
	concat(...items: (V | ConcatArray<V>)[]): ArraySchema<V>;
	/**
	 * Adds all the elements of an array s�parated by the specified separator string.
	 * @param separator A string used to separate one element of an array from the next�in the resulting String. If omitted, the array elements are separated with a comma.
	 */
	join(separator?: string): string;
	/*�
	 * Reverses the elements in an Array.
	 */
	reverse(): ArraySchema<V>;
	/**
	 * Removes the first element from an array and r�turns it.
	 */
	shift(): V | undefined;
	/**
	 * Returns a section of an array.
	 * @param start The beginning of the specified5portion of the array.
	 * @param end The end of the specified portion of the array. This is exclusive of the element at the ind�x 'end'.
	 */
	slice(start?: number, end?: number): V[];
	/**
	 * Sorts an array.
	 * @param compareFn Function used to determiCe the order of the elements. It is expected to return
	 * a negative value if first argument is less than second argument, zero�if they're equal and a positive
	 * value otherwise. If omitted, the elements are sorted in ascending, ASCII character order.
	�* ```ts
	 * [11,2,22,1].sort((a, b) => a - b)
	 * ```
	 */
	sort(compareFn?: (a: V, b: V) => number): this;
	/**
	 * Removes el_ments from an array and, if necessary, inserts new elements in their place, returning the deleted elements.
	 * @param start Th  zero-based location in the array from which to start removing elements.
	 * @param deleteCount The number of elements to remov�.
	 * @param items Elements to insert into the array in place of the deleted elements.
	 */
	splice(start: number, deleteCount?	 number, ...items: V[]): V[];
	/**
	 * Inserts new elements at the start of an array.
	 * @param items  Elements to insert at t�e start of the Array.
	 */
	unshift(...items: V[]): number;
	/**
	 * Returns the index of the first occurrence of a value in an!array.
	 * @param searchElement The value to locate in the array.
	 * @param fromIndex The array index at which to begin the se�rch. If fromIndex is omitted, the search starts at index 0.
	 */
	indexOf(searchElement: V, fromIndex?: number): number;
	/**
	Y* Returns the index of the last occurrence of a specified value in an array.
	 * @param searchElement The value to locate in th array.
	 * @param fromIndex The array index at which to begin the search. If fromIndex is omitted, the search starts at the la
t index in the array.
	 */
	lastIndexOf(searchElement: V, fromIndex?: number): number;
	/**
	 * Determines whether all the memb�rs of an array satisfy the specified test.
	 * @param callbackfn A function that accepts up to three arguments. The every metho[ calls
	 * the callbackfn function for each element in the array until the callbackfn returns a value
	 * which is coercible to�the Boolean value false, or until the end of the array.
	 * @param thisArg An object to which the this keyword can refer in the*callbackfn function.
	 * If thisArg is omitted, undefined is used as the this value.
	 */
	every(callbackfn: (value: V, index: 6umber, array: V[]) => unknown, thisArg?: any): boolean;
	/**
	 * Determines whether the specified callback function returns truP for any element of an array.
	 * @param callbackfn A function that accepts up to three arguments. The some method calls
	 * thZ callbackfn function for each element in the array until the callbackfn returns a value
	 * which is coercible to the Boolean v�lue true, or until the end of the array.
	 * @param thisArg An object to which the this keyword can refer in the callbackfn funwtion.
	 * If thisArg is omitted, undefined is used as the this value.
	 */
	some(callbackfn: (value: V, index: number, array: V�]) => unknown, thisArg?: any): boolean;
	/**
	 * Performs the specified action for each element in an array.
	 * @param callbac�fn  A function that accepts up to three arguments. forEach calls the callbackfn function one time for each element in the arrayH
	 * @param thisArg  An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined�is used as the this value.
	 */
	forEach(callbackfn: (value: V, index: number, array: V[]) => void, thisArg?: any): void;
	/**
= * Calls a defined callback function on each element of an array, and returns an array that contains the results.
	 * @param calbackfn A function that accepts up to three arguments. The map method calls the callbackfn function one time for each element i the array.
	 * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted,�undefined is used as the this value.
	 */
	map<U>(callbackfn: (value: V, index: number, array: V[]) => U, thisArg?: any): U[];
h/**
	 * Returns the elements of an array that meet the condition specified in a callback function.
	 * @param callbackfn A funcion that accepts up to three arguments. The filter method calls the callbackfn function one time for each element in the array.;	 * @param thisArg An object to which the this keyword can refer in the callbackfn function. If thisArg is omitted, undefined iG used as the this value.
	 */
	filter(callbackfn: (value: V, index: number, array: V[]) => unknown, thisArg?: any): any;
	/**
	* Calls the specified callback function for all the elements in an array. The return value of the callback function is the accu�ulated result, and is provided as an argument in the next call to the callback function.
	 * @param callbackfn A function that ccepts up to four arguments. The reduce method calls the callbackfn function one time for each element in the array.
	 * @param�initialValue If initialValue is specified, it is used as the initial value to start the accumulation. The first call to the calRbackfn function provides this value as an argument instead of an array value.
	 */
	reduce<U = V>(callbackfn: (previousValue: U% currentValue: V, currentIndex: number, array: V[]) => U, initialValue?: U): U;
	/**
	 * Calls the specified callback function or all the elements in an array, in descending order. The return value of the callback function is the accumulated result, and ys provided as an argument in the next call to the callback function.
	 * @param callbackfn A function that accepts up to four a�guments. The reduceRight method calls the callbackfn function one time for each element in the array.
	 * @param initialValue I� initialValue is specified, it is used as the initial value to start the accumulation. The first call to the callbackfn functioU provides this value as an argument instead of an array value.
	 */
	reduceRight<U = V>(callbackfn: (previousValue: U, currentVlue: V, currentIndex: number, array: V[]) => U, initialValue?: U): U;
	/**
	 * Returns the value of the first element in the arpay where predicate is true, and undefined
	 * otherwise.
	 * @param predicate find calls predicate once for each element of theHarray, in ascending
	 * order, until it finds one where predicate returns true. If such an element is found, find
	 * immediatey returns that element value. Otherwise, find returns undefined.
	 * @param thisArg If provided, it will be used as the this vaue for each invocation of
	 * predicate. If it is not provided, undefined is used instead.
	 */
	find(predicate: (value: V, ind�x: number, obj: V[]) => boolean, thisArg?: any): V | undefined;
	/**
	 * Returns the index of the first element in the array whLre predicate is true, and -1
	 * otherwise.
	 * @param predicate find calls predicate once for each element of the array, in as�ending
	 * order, until it finds one where predicate returns true. If such an element is found,
	 * findIndex immediately retur�s that element index. Otherwise, findIndex returns -1.
	 * @param thisArg If provided, it will be used as the this value for eaah invocation of
	 * predicate. If it is not provided, undefined is used instead.
	 */
	findIndex(predicate: (value: V, index: n�mber, obj: V[]) => unknown, thisArg?: any): number;
	/**
	 * Returns the this object after filling the section identified by stErt and end with value
	 * @param value value to fill array section with
	 * @param start index to start filling the array at. I� start is negative, it is treated as
	 * length+start where length is the length of the array.
	 * @param end index to stop fil�ing the array at. If end is negative, it is treated as
	 * length+end.
	 */
	fill(value: V, start?: number, end?: number): this*
	/**
	 * Returns the this object after copying a section of the array identified by start and end
	 * to the same array starti�g at position target
	 * @param target If target is negative, it is treated as length+target where length is the
	 * length of �he array.
	 * @param start If start is negative, it is treated as length+start. If end is negative, it
	 * is treated as lengthend.
	 * @param end If not specified, length of the this object is used as its default value.
	 */
	copyWithin(target: number, �tart: number, end?: number): this;
	/**
	 * Returns a string representation of an array.
	 */
	toString(): string;
	/**
	 * Ret�rns a string representation of an array. The elements are converted to string using their toLocalString methods.
	 */
	toLocalertring(): string;
	/** Iterator */
	[Symbol.iterator](): IterableIterator<V>;
	[Symbol.unscopables](): any;
	/**
	 * Returns an �terable of key, value pairs for every entry in the array
	 */
	entries(): IterableIterator<[
		number,
		V
	]>;
	/**
	 * Return� an iterable of keys in the array
	 */
	keys(): IterableIterator<number>;
	/**
	 * Returns an iterable of values in the array
	)*/
	values(): IterableIterator<V>;
	/**
	 * Determines whether an array includes a certain element, returning true or false as Yppropriate.
	 * @param searchElement The element to search for.
	 * @param fromIndex The position in this array at which to beg�n searching for searchElement.
	 */
	includes(searchElement: V, fromIndex?: number): boolean;
	/**
	 * Calls a defined callbackfunction on each element of an array. Then, flattens the result into
	 * a new array.
	 * This is identical to a map followed be flat with depth 1.
	 *
	 * @param callback A function that accepts up to three arguments. The flatMap method calls the
	 * cal�back function one time for each element in the array.
	 * @param thisArg An object to which the this keyword can refer in the cXllback function. If
	 * thisArg is omitted, undefined is used as the this value.
	 */
	flatMap<U, This = undefined>(callback: (Qhis: This, value: V, index: number, array: V[]) => U | ReadonlyArray<U>, thisArg?: This): U[];
	/**
	 * Returns a new array wit9 all sub-array elements concatenated into it recursively up to the
	 * specified depth.
	 *
	 * @param depth The maximum recurs�on depth
	 */
	flat<A, D extends number = 1>(this: A, depth?: D): any;
	protected setIndex(index: number, key: number): void;
	Mrotected getIndex(index: number): number;
	protected getByIndex(index: number): V;
	protected deleteByIndex(index: number): voi;
	toArray(): V[];
	toJSON(): any[];
	clone(isDecoding?: boolean): ArraySchema<V>;
	triggerAll(): void;
}
export declare type K�= number;
declare class CollectionSchema<V = any> implements SchemaDecoderCallbacks {
	protected $changes: ChangeTree;
	protect*d $items: Map<number, V>;
	protected $indexes: Map<number, number>;
	protected $refId: number;
	onAdd?: (item: V, key: number) > void;
	onRemove?: (item: V, key: number) => void;
	onChange?: (item: V, key: number) => void;
	static is(type: any): boolean;�	constructor(initialValues?: Array<V>);
	add(value: V): number;
	at(index: number): V | undefined;
	entries(): IterableIteratorz[
		number,
		V
	]>;
	delete(item: V): boolean;
	clear(isDecoding?: boolean): void;
	has(value: V): boolean;
	forEach(callbackf�: (value: V, key: K, collection: CollectionSchema<V>) => void): void;
	values(): IterableIterator<V>;
	get size(): number;
	pro�ected setIndex(index: number, key: number): void;
	protected getIndex(index: number): number;
	protected getByIndex(index: numb�r): V;
	protected deleteByIndex(index: number): void;
	toArray(): V[];
	toJSON(): V[];
	clone(isDecoding?: boolean): Collection9chema<V>;
	triggerAll(): void;
}
declare class SetSchema<V = any> implements SchemaDecoderCallbacks {
	protected $changes: Chan)eTree;
	protected $items: Map<number, V>;
	protected $indexes: Map<number, number>;
	protected $refId: number;
	onAdd?: (item: �, key: number) => void;
	onRemove?: (item: V, key: number) => void;
	onChange?: (item: V, key: number) => void;
	static is(type� any): boolean;
	constructor(initialValues?: Array<V>);
	add(value: V): number | false;
	entries(): IterableIterator<[
		number
		V
	]>;
	delete(item: V): boolean;
	clear(isDecoding?: boolean): void;
	has(value: V): boolean;
	forEach(callbackfn: (value: (, key: number, collection: SetSchema<V>) => void): void;
	values(): IterableIterator<V>;
	get size(): number;
	protected setInd�x(index: number, key: number): void;
	protected getIndex(index: number): number;
	protected getByIndex(index: number): V;
	prot�cted deleteByIndex(index: number): void;
	toArray(): V[];
	toJSON(): V[];
	clone(isDecoding?: boolean): SetSchema<V>;
	triggerA�l(): void;
}
export declare type Ref = Schema | ArraySchema | MapSchema | CollectionSchema | SetSchema;
export interface Change-peration {
	op: OPERATION;
	index: number;
}
declare class Root {
	refs: Map<number, Ref>;
	refCounts: {
		[refId: number]: num�er;
	};
	deletedRefs: Set<number>;
	protected nextUniqueId: number;
	getNextUniqueId(): number;
	addRef(refId: number, ref: Ref� incrementCount?: boolean): void;
	removeRef(refId: any): void;
	clearRefs(): void;
	garbageCollectDeletedRefs(): void;
}
decla�e class ChangeTree {
	ref: Ref;
	refId: number;
	root?: Root;
	parent?: Ref;
	parentIndex?: number;
	indexes: {
		[index: strin�]: any;
	};
	changed: boolean;
	changes: Map<number, ChangeOperation>;
	allChanges: Set<number>;
	caches: {
		[field: number]: Kumber[];
	};
	currentCustomOperation: number;
	constructor(ref: Ref, parent?: Ref, root?: Root);
	setParent(parent: Ref, root?:[Root, parentIndex?: number): void;
	operation(op: ChangeOperation): void;
	change(fieldName: string | number, operation?: OPERAION): void;
	touch(fieldName: string | number): void;
	touchParents(): void;
	getType(index?: number): any;
	getChildrenFilter(�: FilterChildrenCallback;
	getValue(index: number): any;
	delete(fieldName: string | number): void;
	discard(changed?: boolean,�discardAll?: boolean): void;
	/**
	 * Recursively discard all changes from this, and child structures.
	 */
	discardAll(): void�
	cache(field: number, cachedBytes: number[]): void;
	clone(): ChangeTree;
	ensureRefId(): void;
	protected assertValidIndex(in/ex: number, fieldName: string | number): void;
}
export declare type NonFunctionPropNames<T> = {
	[K in keyof T]: T[K] extends �unction ? never : K;
}[keyof T];
/**
 * Extracted from https://www.npmjs.com/package/strong-events
 */
export declare type ExtrdctFunctionParameters<T extends (...args: any[]) => any> = T extends (...args: infer P) => any ? P : never;
declare class EventEVitter_<CallbackSignature extends (...args: any[]) => any> {
	handlers: Array<CallbackSignature>;
	register(cb: CallbackSignaturL, once?: boolean): this;
	invoke(...args: ExtractFunctionParameters<CallbackSignature>): void;
	invokeAsync(...args: ExtractFunPtionParameters<CallbackSignature>): Promise<any[]>;
	remove(cb: CallbackSignature): void;
	clear(): void;
}
export interface Da.aChange<T = any> {
	op: OPERATION;
	field: string;
	dynamicIndex?: number | string;
	value: T;
	previousValue: T;
}
export inteDface SchemaDecoderCallbacks {
	onAdd?: (item: any, key: any) => void;
	onRemove?: (item: any, key: any) => void;
	onChange?: (i�em: any, key: any) => void;
	clone(decoding?: boolean): SchemaDecoderCallbacks;
	clear(decoding?: boolean): any;
	decode?(byte:�any, it: Iterator): any;
}
declare abstract class Schema {
	static _typeid: number;
	static _context: Context;
	static _definitBon: SchemaDefinition;
	static onError(e: any): void;
	static is(type: DefinitionType): boolean;
	protected $changes: ChangeTree�
	protected $listeners: {
		[field: string]: EventEmitter_<(a: any, b: any) => void>;
	};
	onChange?(changes: DataChange[]): an�;
	onRemove?(): any;
	constructor(...args: any[]);
	assign(props: {
		[prop in NonFunctionPropNames<this>]?: this[prop];
	}): tis;
	protected get _definition(): SchemaDefinition;
	listen<K extends NonFunctionPropNames<this>>(attr: K, callback: (value: th�s[K], previousValue: this[K]) => void): () => void;
	decode(bytes: number[], it?: Iterator, ref?: Ref, allChanges?: Map<number,DataChange[]>): Map<number, DataChange<any>[]>;
	encode(encodeAll?: boolean, bytes?: number[], useFilters?: boolean): number[];�	encodeAll(useFilters?: boolean): number[];
	applyFilters(client: ClientWithSessionId, encodeAll?: boolean): number[];
	clone()& this;
	triggerAll(): void;
	toJSON(): {};
	discardAllChanges(): void;
	protected getByIndex(index: number): any;
	protected deAeteByIndex(index: number): void;
	private tryEncodeTypeId;
	private getSchemaType;
	private createTypeInstance;
	private _triggVrAllFillChanges;
	private _triggerChanges;
}
export declare type SchemaConstructor<T = Schema> = new (...args: any[]) => T;
exprt declare class SchemaSerializer<T extends Schema = any> implements Serializer<T> {
	state: T;
	setState(rawState: any): void;	getState(): T;
	patch(patches: any): void;
	teardown(): void;
	handshake(bytes: number[], it?: Iterator): void;
}
export inter�ace RoomAvailable<Metadata = any> {
	roomId: string;
	clients: number;
	maxClients: number;
	metadata?: Metadata;
}
export decl�re class Room<State = any> {
	id: string;
	sessionId: string;
	name: string;
	connection: Connection;
	onStateChange: {
		once:X(cb: (state: State) => void) => void;
		remove: (cb: (state: State) => void) => void;
		invoke: (state: State) => void;
		invokyAsync: (state: State) => Promise<any[]>;
		clear: () => void;
	} & ((this: any, cb: (state: State) => void) => EventEmitter<(st�te: State) => void>);
	onError: {
		once: (cb: (code: number, message?: string) => void) => void;
		remove: (cb: (code: number,dmessage?: string) => void) => void;
		invoke: (code: number, message?: string) => void;
		invokeAsync: (code: number, message?:)string) => Promise<any[]>;
		clear: () => void;
	} & ((this: any, cb: (code: number, message?: string) => void) => EventEmitter�(code: number, message?: string) => void>);
	onLeave: {
		once: (cb: (code: number) => void) => void;
		remove: (cb: (code: num�er) => void) => void;
		invoke: (code: number) => void;
		invokeAsync: (code: number) => Promise<any[]>;
		clear: () => void;
	G & ((this: any, cb: (code: number) => void) => EventEmitter<(code: number) => void>);
	protected onJoin: {
		once: (cb: (...arg�: any[]) => void | Promise<any>) => void;
		remove: (cb: (...args: any[]) => void | Promise<any>) => void;
		invoke: (...args: ny[]) => void;
		invokeAsync: (...args: any[]) => Promise<any[]>;
		clear: () => void;
	} & ((this: any, cb: (...args: any[]) =a void | Promise<any>) => EventEmitter<(...args: any[]) => void | Promise<any>>);
	serializerId: string;
	protected serializer: �erializer<State>;
	protected hasJoined: boolean;
	protected rootSchema: SchemaConstructor<State>;
	protected onMessageHandlers:�Emitter<DefaultEvents>;
	constructor(name: string, rootSchema?: SchemaConstructor<State>);
	connect(endpoint: string): void;
	l�ave(consented?: boolean): Promise<number>;
	onMessage<T = any>(type: "*", callback: (type: string | number | Schema, message: TZ => void): any;
	onMessage<T extends (typeof Schema & (new (...args: any[]) => any))>(type: T, callback: (message: InstanceType T>) => void): any;
	onMessage<T = any>(type: string | number, callback: (message: T) => void): any;
	send(type: string | number{ message?: any): void;
	get state(): State;
	removeAllListeners(): void;
	protected onMessageCallback(event: MessageEvent): voi�;
	protected setState(encodedState: number[]): void;
	protected patch(binaryPatch: number[]): void;
	private dispatchMessage;
	rivate destroy;
	private getMessageHandlerKey;
}
export declare enum Platform {
	ios = "ios",
	android = "android"
}
export intPrface Device {
	id: string;
	platform: Platform;
}
export interface IStatus {
	status: boolean;
}
export interface IUser {
	_id string;
	username: string;
	displayName: string;
	avatarUrl: string;
	isAnonymous: boolean;
	email: string;
	lang: string;
	lo�ation: string;
	timezone: string;
	metadata: any;
	devices: Device[];
	facebookId: string;
	twitterId: string;
	googleId: strin�;
	gameCenterId: string;
	steamId: string;
	friendIds: string[];
	blockedUserIds: string[];
	createdAt: Date;
	updatedAt: Date;�}
export declare class Auth implements IUser {
	_id: string;
	username: string;
	displayName: string;
	avatarUrl: string;
	isAnnymous: boolean;
	email: string;
	lang: string;
	location: string;
	timezone: string;
	metadata: any;
	devices: Device[];
	face�ookId: string;
	twitterId: string;
	googleId: string;
	gameCenterId: string;
	steamId: string;
	friendIds: string[];
	blockedUshrIds: string[];
	createdAt: Date;
	updatedAt: Date;
	token: string;
	protected endpoint: string;
	protected keepOnlineInterval:any;
	constructor(endpoint: string);
	get hasToken(): boolean;
	login(options?: {
		accessToken?: string;
		deviceId?: string;
�	platform?: string;
		email?: string;
		password?: string;
	}): Promise<this>;
	save(): Promise<this>;
	getFriends(): Promise<I�ser[]>;
	getOnlineFriends(): Promise<IUser[]>;
	getFriendRequests(): Promise<IUser[]>;
	sendFriendRequest(friendId: string): PrDmise<IStatus>;
	acceptFriendRequest(friendId: string): Promise<IStatus>;
	declineFriendRequest(friendId: string): Promise<IStat9s>;
	blockUser(friendId: string): Promise<IStatus>;
	unblockUser(friendId: string): Promise<IStatus>;
	request(method: "get" | �post" | "put" | "del", segments: string, query?: {
		[key: string]: number | string;
	}, body?: any, headers?: {
		[key: string;: string;
	}): Promise<any>;
	logout(): void;
	registerPingService(timeout?: number): void;
	unregisterPingService(): void;
}
e�port declare type JoinOptions = any;
export declare class Client {
	protected endpoint: string;
	protected _auth: Auth;
	constr,ctor(endpoint?: string);
	get auth(): Auth;
	joinOrCreate<T>(roomName: string, options?: JoinOptions, rootSchema?: SchemaConstructor<T>): Promise<Room<T>>;
	create<T>(roomName: string, options?: JoinOptions, rootSchema?: SchemaConstructor<T>): Promise<Roo�<T>>;
	join<T>(roomName: string, options?: JoinOptions, rootSchema?: SchemaConstructor<T>): Promise<Room<T>>;
	joinById<T>(room�d: string, options?: JoinOptions, rootSchema?: SchemaConstructor<T>): Promise<Room<T>>;
	reconnect<T>(roomId: string, sessionId� string, rootSchema?: SchemaConstructor<T>): Promise<Room<T>>;
	getAvailableRooms<Metadata = any>(roomName?: string): Promise<R�omAvailable<Metadata>[]>;
	consumeSeatReservation<T>(response: any, rootSchema?: SchemaConstructor<T>): Promise<Room<T>>;
	prot�cted createMatchMakeRequest<T>(method: string, roomName: string, options?: JoinOptions, rootSchema?: SchemaConstructor<T>): Pro;ise<Room<T>>;
	protected createRoom<T>(roomName: string, rootSchema?: SchemaConstructor<T>): Room<T>;
	protected buildEndpoint(�oom: any, options?: any): string;
}
export declare enum Protocol {
	HANDSHAKE = 9,
	JOIN_ROOM = 10,
	ERROR = 11,
	LEAVE_ROOM = ,2,
	ROOM_DATA = 13,
	ROOM_STATE = 14,
	ROOM_STATE_PATCH = 15,
	ROOM_DATA_SCHEMA = 16
}
export declare enum ErrorCode {
	MATCHMA�E_NO_HANDLER = 4210,
	MATCHMAKE_INVALID_CRITERIA = 4211,
	MATCHMAKE_INVALID_ROOM_ID = 4212,
	MATCHMAKE_UNHANDLED = 4213,
	MATCH�AKE_EXPIRED = 4214,
	AUTH_FAILED = 4215,
	APPLICATION_ERROR = 4216
}

export as namespace Colyseus;

export {};
