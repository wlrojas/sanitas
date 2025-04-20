<template>
  <v-text-field
      v-bind="attrs"
      v-on="listeners"
      :label="label"
      :type="type"
      :rules="rules"
      :clearable="clearable"
      :outlined="outlined"
      v-model="modelValue"
  />
</template>

<script setup>
import { toRefs } from 'vue'
import { useAttrs, useSlots, useListeners } from 'vue'
import { defineProps, defineEmits } from 'vue'

// Props que expone el wrapper
const props = defineProps({
  label:   { type: String, default: '' },
  type:    { type: String, default: 'text' },
  rules:   { type: Array,  default: () => [] },
  clearable: { type: Boolean, default: false },
  outlined:  { type: Boolean, default: true },
  modelValue: [String, Number]
})

// Emit para v-model
const emit = defineEmits(['update:modelValue'])

// Reenvía atributos y listeners a v-text-field
const attrs    = useAttrs()
const listeners = {
  ...useListeners(),
  input: val => emit('update:modelValue', val)
}
</script>
