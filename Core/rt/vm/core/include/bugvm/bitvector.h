/*
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Miscellaneous utility functions.
 */
#ifndef BUGVM_BITVECTOR_H_
#define BUGVM_BITVECTOR_H_

#include <jni.h>
#include <stdint.h>

typedef struct BitVector BitVector;
typedef struct BitVectorIterator BitVectorIterator;

/*
 * Expanding bitmap, used for tracking resources.  Bits are numbered starting
 * from zero.
 *
 * All operations on a BitVector are unsynchronized.
 */
struct BitVector {
    jboolean  expandable;     /* expand bitmap if we run out? */
    uint32_t  storageSize;    /* current size, in 32-bit words */
    uint32_t* storage;
};

/* Handy iterator to walk through the bit positions set to 1 */
struct BitVectorIterator {
    BitVector *pBits;
    uint32_t  idx;
    uint32_t  bitSize;
};

/* allocate a bit vector with enough space to hold "startBits" bits */
BitVector* bugvmAllocBitVector(uint32_t startBits, jboolean expandable);
void bugvmFreeBitVector(BitVector* pBits);

/*
 * dvmAllocBit always allocates the first possible bit.  If we run out of
 * space in the bitmap, and it's not marked expandable, dvmAllocBit
 * returns -1.
 *
 * dvmSetBit sets the specified bit, expanding the vector if necessary
 * (and possible).  Attempting to set a bit past the limit of a non-expandable
 * bit vector will cause a fatal error.
 *
 * dvmSetInitialBits sets all bits in [0..numBits-1]. Won't expand the vector.
 *
 * dvmIsBitSet returns "true" if the bit is set.
 */
jint bugvmAllocBit(BitVector* pBits);
void bugvmSetBit(BitVector* pBits, uint32_t num);
void bugvmClearBit(BitVector* pBits, uint32_t num);
void bugvmClearAllBits(BitVector* pBits);
void bugvmSetInitialBits(BitVector* pBits, uint32_t numBits);
jboolean bugvmIsBitSet(const BitVector* pBits, uint32_t num);

/* count the number of bits that have been set */
jint bugvmCountSetBits(const BitVector* pBits);

/* copy one vector to another of equal size */
void bugvmCopyBitVector(BitVector *dest, const BitVector *src);

/*
 * Intersect two bit vectors and store the result to the dest vector.
 */
jboolean bugvmIntersectBitVectors(BitVector *dest, const BitVector *src1,
        const BitVector *src2);

/*
 * Unify two bit vectors and store the result to the dest vector.
 */
jboolean bugvmUnifyBitVectors(BitVector *dest, const BitVector *src1,
        const BitVector *src2);

/*
 * Merge the contents of "src" into "dst", checking to see if this causes
 * any changes to occur.
 *
 * Returns "true" if the contents of the destination vector were modified.
 */
jboolean bugvmCheckMergeBitVectors(BitVector* dst, const BitVector* src);

/*
 * Compare two bit vectors and return true if difference is seen.
 */
jboolean bugvmCompareBitVectors(const BitVector *src1, const BitVector *src2);

/* Initialize the iterator structure */
void bugvmBitVectorIteratorInit(BitVector* pBits, BitVectorIterator* iterator);

/* Return the next position set to 1. -1 means end-of-vector reached */
jint bugvmBitVectorIteratorNext(BitVectorIterator* iterator);

#endif  // BUGVM_BITVECTOR_H_
